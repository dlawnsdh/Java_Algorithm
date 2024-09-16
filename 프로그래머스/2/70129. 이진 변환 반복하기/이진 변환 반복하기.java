import java.util.*;

class Solution {
    int[] remeveZero(String s, int cnt, int num) {
        if (s.equals("1")) return new int[] {cnt, num};
        else {
            String r0 = s.replaceAll("0", "");
            int zero = s.length() - r0.length();
            return remeveZero(Integer.toBinaryString(r0.length()), cnt + 1, num + zero);    
        }
    }
    
    public int[] solution(String s) {
        return remeveZero(s, 0, 0);
    }
}