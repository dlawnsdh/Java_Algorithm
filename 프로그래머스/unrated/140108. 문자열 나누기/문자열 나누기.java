import java.util.*;

class Solution {
    public int solution(String s) {
        int cnt = 0;
        Queue<Character> yx = new LinkedList<>();
        Queue<Character> nx = new LinkedList<>();
        
        int i = 0;
        for (; i < s.length(); i++) {
            if (yx.size() == 0) 
                yx.add(s.charAt(i));
            else {
                if (yx.peek() == s.charAt(i)) 
                    yx.add(s.charAt(i));
                else nx.add(s.charAt(i));
            }
            
            if (yx.size() == nx.size()) {
                yx.clear();
                nx.clear();
                s = s.substring(i + 1);
                cnt++;
                i = -1;
            }
        }
        if (yx.size() != 0)
            cnt++;
        
        return cnt;
    }
}