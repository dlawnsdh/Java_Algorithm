import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[1000][3];
        
        String[] tmp = br.readLine().split(" ");
        dp[0][0] = Integer.parseInt(tmp[0]);
        dp[0][1] = Integer.parseInt(tmp[1]);
        dp[0][2] = Integer.parseInt(tmp[2]);
        for (int i = 1; i < n; i++) {
            String[] rgb = br.readLine().split(" ");
            dp[i][0] = Integer.parseInt(rgb[0]) + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = Integer.parseInt(rgb[1]) + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = Integer.parseInt(rgb[2]) + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        System.out.print(Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2])));
    }
}