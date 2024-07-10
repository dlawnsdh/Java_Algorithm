class Solution {
    public int solution(int[][] board) {
        int[][] dp = new int[board.length + 1][board[0].length + 1];
        
        int max = 0;
        for (int i = 1; i < dp.length; i++)
            for (int k = 1; k < dp[0].length; k++) 
                if (board[i - 1][k - 1] == 1) {
                    dp[i][k] = Math.min(Math.min(dp[i - 1][k - 1], dp[i - 1][k]), dp[i][k - 1]) + 1;
                    max = Math.max(max, dp[i][k]);
                }
            
        return max * max;
    }
}