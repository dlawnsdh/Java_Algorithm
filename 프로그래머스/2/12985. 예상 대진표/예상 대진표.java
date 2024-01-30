class Solution {
    public int solution(int n, int a, int b) {
        int cnt = 1;
        while (n > 1) {
            if (Math.max(a, b) % 2 == 0 && Math.abs(a - b) == 1) 
                break;
            if (a % 2 == 0) a /= 2;
            else a = (a + 1) / 2;
            if (b % 2 == 0) b /= 2;
            else b = (b + 1) / 2;
            cnt++;
            n /= 2;
        }
        return cnt;
    }
}