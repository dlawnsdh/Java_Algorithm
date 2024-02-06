import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[101];
            dp[1] = 1; dp[2] = 1; dp[3] = 1; dp[4] = 2; dp[5] = 2;
            for (int k = 6; k <= n; k++) 
                dp[k] = dp[k - 1] + dp[k - 5];
            System.out.println(dp[n]);
        }
    }
}