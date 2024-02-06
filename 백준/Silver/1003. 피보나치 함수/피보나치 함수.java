import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[41][2];
            dp[0] = new int[] {1, 0};
            dp[1] = new int[] {0, 1};
            for (int k = 2; k <= n; k++)
                dp[k] = new int[] {dp[k - 1][0] + dp[k - 2][0], dp[k - 1][1] + dp[k - 2][1]};
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}