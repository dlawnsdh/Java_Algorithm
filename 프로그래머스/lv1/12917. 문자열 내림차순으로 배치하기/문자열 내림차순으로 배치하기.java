import java.util.*;

class Solution {
    public String solution(String s) {
        String[] str = s.split("");
        Arrays.sort(str, Collections.reverseOrder());
        String result = "";
        for (int i = 0; i < str.length; i++) 
            result += str[i];
        return result;
    }
}