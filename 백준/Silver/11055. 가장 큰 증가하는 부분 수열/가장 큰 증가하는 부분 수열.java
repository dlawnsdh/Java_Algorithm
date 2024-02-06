import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i <= n; i++) {
            dp[i] = arr[i];
            for (int k = 1; k < i; k++)
                if (arr[i] > arr[k])
                    dp[i] = Math.max(dp[k] + arr[i], dp[i]);
        }
        Arrays.sort(dp);
        System.out.print(dp[n]);
    }
}