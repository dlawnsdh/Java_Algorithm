class Solution {
    public int solution(int n) {
        int cnt = 0;
        for (int i = 1; i <= n / 2; i++) {
            int sum = 0;
            int k = i;
            while (sum < n) {
                sum += k;
                k++;
            }
            if (sum == n) cnt++;
        }
        return cnt + 1;
    }
}