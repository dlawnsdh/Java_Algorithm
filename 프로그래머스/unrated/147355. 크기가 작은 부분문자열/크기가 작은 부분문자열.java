import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int cnt = 0;
        long P = Long.parseLong(p);
        for (int i = 0; i < t.length(); i++) {
            int tmp = i + p.length();
            if (tmp <= t.length()) {
                long sub = Long.parseLong(t.substring(i, tmp));
                if (sub <= P)
                    cnt++;
            }
            else break;
        }
        return cnt;
    }
}