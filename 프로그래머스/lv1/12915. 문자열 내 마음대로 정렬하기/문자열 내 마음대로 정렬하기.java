import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        for (int i = strings.length - 1; i > 0; i--) 
            for (int k = 0; k < i; k++) {
                if (strings[k].charAt(n) > strings[i].charAt(n)) {
                    String tmp = strings[i];
                    strings[i] = strings[k];
                    strings[k] = tmp;
                }
                if (strings[k].charAt(n) == strings[i].charAt(n)) {
                    String[] str = new String[2];
                    str[0] = strings[i];
                    str[1] = strings[k];
                    Arrays.sort(str);
                    strings[k] = str[0];
                    strings[i] = str[1];
                }
            }
        

        return strings;
    }
}