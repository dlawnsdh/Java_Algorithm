import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        StringBuilder s = new StringBuilder();
        int cnt = 0;
        
        for (int i = 0; i < ingredient.length; i++) {
            if (s.length() == 0) {
                if (ingredient[i] == 1)
                    s.append(ingredient[i]);
            }
            else s.append(ingredient[i]);
            
            if (s.length() > 3 && s.substring(s.length() - 4, s.length()).equals("1231")) {
                s = s.delete(s.length() - 4, s.length());
                cnt++;
            }
        }
        
        return cnt;
    }
}