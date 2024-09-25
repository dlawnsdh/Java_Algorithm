import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        for (int i = 0; i < 4; i++)
            dp[0][i] = land[0][i];
        
        for (int i = 1; i < dp.length; i++)
            for (int k = 0; k < 4; k++) {
                int max = 0;
                for (int j = 0; j < 4; j++) {
                    if (j == k) continue;
                    max = Math.max(max, dp[i - 1][j]);
                }
                dp[i][k] = land[i][k] + max;
            }
        return Arrays.stream(dp[dp.length - 1]).max().getAsInt();
    }
}