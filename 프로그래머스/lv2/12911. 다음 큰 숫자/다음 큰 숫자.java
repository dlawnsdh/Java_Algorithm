import java.util.*;
class Solution {
    public int solution(int n) {
        String s = Integer.toBinaryString(n);
        
        int a = n;
        if (!s.contains("0"))
            return n + (int) Math.pow(2, s.length() - 1);

        while (true) {
            if (Integer.bitCount(++a) == Integer.bitCount(n))
                return a;

        }
    }
}