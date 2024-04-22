import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String s) {
        int min = s.length();
        for (int idx = 1; idx <= s.length() / 2; idx++) {
            String regex = String.format("[a-z]{1,%d}", idx);
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(s);    
            
            List<String> l = new ArrayList<>();
            while (m.find())
                l.add(m.group());
            
            StringBuilder b = new StringBuilder();
            int index = 0;
            int cnt = 1;
            for (int i = 1; i < l.size(); i++) {
                if (l.get(index).equals(l.get(i))) cnt++;
                else {
                    if (cnt == 1) b.append(l.get(index));
                    else b.append(cnt).append(l.get(index));
                    index = i;
                    cnt = 1;
                }
            }
            
            if (cnt > 1) b.append(cnt).append(l.get(index));
            else b.append(l.get(l.size() - 1));
            min = Math.min(min, b.length());
        }
        return min;
    }
}