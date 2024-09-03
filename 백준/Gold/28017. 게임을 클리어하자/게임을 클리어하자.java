import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] weapon = new int[n][m];
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < m; k++)
                weapon[i][k] = Integer.parseInt(st.nextToken());
        }
        
        System.arraycopy(weapon[0], 0, dp[0], 0, m);
        for (int i = 1; i < n; i++)
            for (int k = 0; k < m; k++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    if (k == j) continue;
                    min = Math.min(min, dp[i - 1][j]);
                }
                dp[i][k] = weapon[i][k] + min;
            }
        Arrays.sort(dp[n - 1]);
        System.out.print(dp[n - 1][0]);
    }
}