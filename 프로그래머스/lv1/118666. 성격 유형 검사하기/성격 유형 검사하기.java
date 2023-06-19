import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String s = "";
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
        Map<String, Integer> m = new HashMap<>();
        m.put("R", 0);
        m.put("T", 0);
        m.put("C", 0);
        m.put("F", 0);
        m.put("J", 0);
        m.put("M", 0);
        m.put("A", 0);
        m.put("N", 0);
        
        for (int i = 0; i < survey.length; i++) {
            String str = "";
            if (choices[i] > 0 && choices[i] < 4) 
                str = String.valueOf(survey[i].charAt(0));
            else if (choices[i] > 4 && choices[i] < 8) 
                str = String.valueOf(survey[i].charAt(1));
            
            if (!str.isEmpty())
                m.put(str, m.get(str) + score[choices[i]]);
        }
        
        if (m.get("R").compareTo(m.get("T")) > 0)
            s += "R";
        else if (m.get("R").compareTo(m.get("T")) < 0) 
            s += "T";
        else s += "R";
        if (m.get("C").compareTo(m.get("F")) > 0)
            s += "C";
        else if (m.get("C").compareTo(m.get("F")) < 0)
            s += "F";
        else s += "C";
        if (m.get("J").compareTo(m.get("M")) > 0)
            s += "J";
        else if (m.get("J").compareTo(m.get("M")) < 0)
            s += "M";
        else s += "J";
        if (m.get("A").compareTo(m.get("N")) > 0)
            s += "A";
        else if (m.get("A").compareTo(m.get("N")) < 0)
            s += "N";
        else s += "A";
        
        return s;
    }
}