import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= m; k++)
                dp[i][k] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <= n; i++)
            for (int k = 1; k <= m; k++)
                dp[i][k] += Math.max(Math.max(dp[i - 1][k], dp[i][k - 1]), dp[i - 1][k - 1]);
        System.out.print(dp[n][m]);
    }
}