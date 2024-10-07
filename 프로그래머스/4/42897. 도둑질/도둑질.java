class Solution {
    int INF = 1000000;
    
    public int solution(int[] money) {
        int[] dp1 = new int[INF];
        int[] dp2 = new int[INF];
        int n = money.length;
        
        // 1번 집부터 털 때 -> 마지막 집은 확정적으로 못 텀
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < n - 1; i++)
            dp1[i] = Math.max(dp1[i - 2] + money[i], dp1[i - 1]);
        
        // 2번 집부터 털 때 -> 첫 번째 집은 확정적으로 못 텀
        dp2[1] = money[1];
        dp2[2] = Math.max(money[1], money[2]);
        for (int i = 3; i < n; i++)
            dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);
        
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}