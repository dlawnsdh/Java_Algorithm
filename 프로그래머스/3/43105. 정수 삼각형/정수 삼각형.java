import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length + 1][triangle.length + 2]; // 양 쪽에 패딩을 위해 2칸 추가
        dp[1][1] = triangle[0][0];
        int max = 0;
        for (int i = 2; i <= triangle.length; i++)
            for (int k = 1; k <= i; k++)
                dp[i][k] = Math.max(dp[i - 1][k - 1], dp[i - 1][k]) + triangle[i - 1][k - 1];
        
        Arrays.sort(dp[triangle.length]);
        return dp[triangle.length][triangle.length + 1];
    }
}