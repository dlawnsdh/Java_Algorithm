import java.util.*;

class Solution {
    public String solution(String p) {
        return isCorrect(p) ? p : makeBracket(p);
    }
    
    public String makeBracket(String s) {
        if (s.isEmpty()) return s;
        
        int n = separateBracket(s);
        String u = s.substring(0, n);
        String v = s.substring(n);
        
        if (isCorrect(u))
            return u + makeBracket(v);
        else {
            StringBuilder b = new StringBuilder();
            u = u.substring(1, u.length() - 1);
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') b.append(')');
                else b.append('(');
            }
            return "(" + makeBracket(v) + ")" + b.toString(); 
        }      
    }
        
    public int separateBracket(String s) {
        int l = 0; 
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') 
                l++;
            else r++;
            if (l == r) break;
        }
        return l + r;
    }
    
    public boolean isCorrect(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty() || !(st.peek() == '(' && s.charAt(i) == ')'))
                st.push(s.charAt(i));
            else st.pop();
        }
        return st.isEmpty() ? true : false;
    }
}