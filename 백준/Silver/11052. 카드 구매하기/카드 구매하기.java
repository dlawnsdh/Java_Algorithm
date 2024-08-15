import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] p = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            p[i] = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i <= n; i++)
            for (int k = 1; k <= i; k++)
                dp[i] = Math.max(dp[i], dp[i - k] + p[k]);
        System.out.print(dp[n]);
    }
}