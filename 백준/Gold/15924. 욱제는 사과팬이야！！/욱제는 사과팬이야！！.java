import java.util.*;
import java.io.*;

public class Main {
    static int INF = 1000000009;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int k = 0; k < m; k++)
                map[i][k + 1] = s.charAt(k);
        }
        
        int count = 0;
        dp[n][m] = 1;
        for (int i = n; i > 0; i--)
            for (int k = m; k > 0; k--) {
                count += dp[i][k] % INF;
                count %= INF;
                if (map[i - 1][k] == 'S' || map[i - 1][k] == 'B') {
                    dp[i - 1][k] += dp[i][k] % INF;
                    dp[i - 1][k] %= INF;
                }
                if (map[i][k - 1] == 'E' || map[i][k - 1] == 'B') {
                    dp[i][k - 1] += dp[i][k] % INF;
                    dp[i][k - 1] %= INF;
                }
            }
        System.out.print(count);
    }
}