import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String s = "";
        String[][] arr = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            m.put(arr[i][0], 0);
            m.put(arr[i][1], 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            String str = "";
            if (choices[i] > 0 && choices[i] < 4) 
                str = String.valueOf(survey[i].charAt(0));
            else if (choices[i] > 4 && choices[i] < 8) 
                str = String.valueOf(survey[i].charAt(1));
            
            if (!str.isEmpty())
                m.put(str, m.get(str) + score[choices[i]]);
        }
        
        for (String[] tmp : arr)
            s += m.get(tmp[0]) >= m.get(tmp[1]) ? tmp[0] : tmp[1];
        
        return s;
    }
}