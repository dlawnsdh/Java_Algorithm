import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] d = new int[n + 1];
        int[] w = new int[n + 1];
        int total = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
            total += w[i];
        }
        
        int[][] dp = new int[n + 1][t + 1];
        for (int i = 1; i <= n; i++)
            for (int k = 1; k <= t; k++) {
                if (d[i] > k) dp[i][k] = dp[i - 1][k];
                else dp[i][k] = Math.max(dp[i - 1][k], dp[i - 1][k - d[i]] + w[i]);
            }
        System.out.print(total - dp[n][t]);
    }
}