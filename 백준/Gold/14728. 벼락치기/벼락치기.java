import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][2];
        int[][] dp = new int[n + 1][t + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <= n; i++)
            for (int k = 0; k <= t; k++) {
                if (arr[i][0] > k) dp[i][k] = dp[i - 1][k];
                else dp[i][k] = Math.max(dp[i - 1][k], arr[i][1] + dp[i - 1][k - arr[i][0]]);
            }
        System.out.print(dp[n][t]);
    }
}