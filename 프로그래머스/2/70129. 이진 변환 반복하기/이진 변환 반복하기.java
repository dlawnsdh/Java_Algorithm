import java.util.*;

class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int sum = 0;
        while (s.length() > 1) {
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == '0') sum++;
            s = Integer.toBinaryString(s.replaceAll("0", "").length());
            cnt++;
        }
        return new int[] {cnt, sum};
    }
}