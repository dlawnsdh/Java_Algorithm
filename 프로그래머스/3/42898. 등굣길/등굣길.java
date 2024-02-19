import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        if (puddles[0].length != 0)
            for (int i = 0; i < puddles.length; i++) 
                map[puddles[i][1]][puddles[i][0]] = 1;
      
        dp[0][1] = 1;
        for (int i = 1; i <= n; i++)
            for (int k = 1; k <= m; k++) {
                if (map[i][k] == 0)
                    dp[i][k] = (dp[i][k - 1] + dp[i - 1][k]) % 1000000007;
            }
        return dp[n][m];
    }
}