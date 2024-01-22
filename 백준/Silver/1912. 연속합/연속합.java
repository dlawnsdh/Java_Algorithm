import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] num = br.readLine().split(" ");
        int[] dp = new int[n];
        
        dp[0] = Integer.parseInt(num[0]);
        for (int i = 1; i < n; i++)
            dp[i] = Integer.parseInt(num[i]) + Math.max(0, dp[i - 1]);
        Arrays.sort(dp);
        System.out.println(dp[n - 1]);
    }
}