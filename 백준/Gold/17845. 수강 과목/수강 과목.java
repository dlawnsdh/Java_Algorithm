import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] importance = new int[k + 1];
        int[] time = new int[k + 1];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            importance[i + 1] = Integer.parseInt(st.nextToken());
            time[i + 1] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= k; i++)
            for (int j = 1; j <= n; j++) {
                if (j < time[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - time[i]] + importance[i]);
            }
        System.out.print(dp[k][n]);
    }
}