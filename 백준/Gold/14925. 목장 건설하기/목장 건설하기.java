import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= m; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
                if (map[i][k] == 0) count++;
            }
        }
        
        if (count == 0) {
            System.out.print(0);
            return;
        }
        int max = 1;
        for (int i = 1; i <= n; i++)
            for (int k = 1; k <= m; k++) {
                if (map[i][k] > 0) continue;
                dp[i][k] = Math.min(Math.min(dp[i - 1][k], dp[i][k - 1]), dp[i - 1][k - 1]) + 1;
                max = Math.max(max, dp[i][k]);
            }
        System.out.print(max);
    }
}