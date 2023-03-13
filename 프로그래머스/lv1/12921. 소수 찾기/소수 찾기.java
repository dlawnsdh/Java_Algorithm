class Solution {
    public int solution(int n) {
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            boolean flag = true;
            for (int k = 2; k <= Math.sqrt(i); k++)
                if (i % k == 0) {
                    flag = false;
                    break;
                }
            if (flag)
                cnt++;
        }
        return cnt;
    }
}