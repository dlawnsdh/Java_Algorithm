import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[301];
        int[] dp = new int[301];
        for (int i = 1; i < n + 1; i++) 
            arr[i] = Integer.parseInt(br.readLine());
        
        for (int i = 1; i < n + 1; i++) {
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
            dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
            if (i > 3) dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
        }
        System.out.print(dp[n]);
    }
}