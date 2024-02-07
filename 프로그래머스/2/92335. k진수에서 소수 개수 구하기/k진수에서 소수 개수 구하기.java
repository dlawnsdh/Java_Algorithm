import java.util.*;

class Solution {
    public int solution(int n, int k) {
        StringBuilder b = new StringBuilder();
        while (n > k) {
            b.append(n % k);
            n /= k;
        }
        b = b.append(n).reverse();
        
        return (int) Arrays.stream(b.toString().split("0"))
            .filter(s -> !s.equals("") && Long.parseLong(s) > 1)
            .mapToLong(Long::parseLong)
            .filter(i -> {
                for (int j = 2; j <= Math.sqrt(i); j++)
                    if (i % j == 0) 
                        return false;
                return true;
            }).count();
    }
}