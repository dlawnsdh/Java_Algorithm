class Solution {
    public int solution(int n) {
        int cnt = 0;
        if (n % 2 != 0) { // 홀 수
            if (n == 1) return 1;
            for (int i = 2; i <= Math.sqrt(n); i++)
                if (n % i == 0) {
                    if (i < Math.sqrt(n)) 
                        cnt += 2;
                    else cnt++; // 25, 81같이 제곱수라면
                }
            return cnt + 2;
        }
        
        else {            // 짝 수
            if (n >= 10) {
                for (int i = 2; i < n; i++)
                    if (n % i == 0 && n / i % 2 != 0)
                        cnt++;
                return cnt + 1;
            }
            else {
                if (n == 6) return 2;
                else return 1;
            }
        }
    }
}