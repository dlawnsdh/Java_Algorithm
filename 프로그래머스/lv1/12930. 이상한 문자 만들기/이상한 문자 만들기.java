import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    public String solution(String s) {
        int cnt = 0;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (c > 64 && c < 91) {
                    if (cnt % 2 != 0)
                        c += 32;
                    str += c;
                }
                else {
                    if (cnt % 2 == 0)
                        c -= 32;
                    str += c;
                }
                cnt++;
            }
            else { 
                cnt = 0;
                str += ' ';   
            }
        }
        return str;
    }
}