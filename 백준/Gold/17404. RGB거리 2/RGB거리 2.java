import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        
        int min = 1000000000;
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                if (i == k) dp[0][k] = arr[0][k];
                else dp[0][k] = 1000000000;
            }
            for (int k = 1; k < n; k++) {
                dp[k][0] = arr[k][0] + Math.min(dp[k - 1][1], dp[k - 1][2]);
                dp[k][1] = arr[k][1] + Math.min(dp[k - 1][0], dp[k - 1][2]);
                dp[k][2] = arr[k][2] + Math.min(dp[k - 1][0], dp[k - 1][1]);
            }
            for (int k = 0; k < 3; k++)
                if (i != k && min > dp[n - 1][k])
                    min = dp[n - 1][k];
        }
        System.out.print(min);
    }
}