import java.util.*;

class Solution {
    public int solution(int n) {
        int k = n + 1;
        while (true) {
            String s1 = Integer.toBinaryString(n);
            String s2 = Integer.toBinaryString(k);
            int sum1 = 0;
            for (int i = 0; i < s1.length(); i++)
                if (s1.charAt(i) == '1') sum1++;
            int sum2 = 0;
            for (int i = 0; i < s2.length(); i++)
                if (s2.charAt(i) == '1') sum2++;
            if (sum1 == sum2) return k;
            k++;
        }
    }
}