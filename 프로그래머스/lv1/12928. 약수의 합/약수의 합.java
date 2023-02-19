class Solution {
    public int solution(int n) {
        if (n <= 1) return n;
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (i == Math.sqrt(n))
                    sum += i;
                else sum += i + n / i;
            }
        }
        return sum + 1 + n;
    }
}