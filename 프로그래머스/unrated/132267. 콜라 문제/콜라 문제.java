class Solution {
    public int solution(int a, int b, int n) {
        int cnt = 0;
        while (n >= a) {
            int rest = n % a;
            int tmp = n / a * b;
            n = tmp + rest;
            cnt += tmp;
        }
        return cnt;
    }
}