import java.util.*;

class Solution {
    boolean isPrime(long n) {
        if (n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
    
    public int solution(int n, int k) {
        return (int) Arrays.stream(Integer.toString(n, k).split("0"))
            .filter(s -> !s.isEmpty() && isPrime(Long.parseLong(s)))
            .count();
    }
}