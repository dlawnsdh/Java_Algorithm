import java.util.*;

class Solution {
    boolean isCorrectBracket(int start, String s) {
        Stack<Character> st = new Stack<>();
        for (int i = start; i < s.length() + start; i++) {
            int idx = i % s.length();
            if (st.isEmpty())
                st.push(s.charAt(idx));
            else if ((st.peek() == '(' && s.charAt(idx) == ')') || (st.peek() == '{' && s.charAt(idx) == '}') || (st.peek() == '[' && s.charAt(idx) == ']'))
                st.pop();
            else st.push(s.charAt(idx));
        }
        return st.isEmpty() ? true : false;
    }
    
    public int solution(String s) {        
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            if (isCorrectBracket(i, s)) 
                count++;
        return count;
    }
}