import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') st.push('(');
            else {
                if (st.isEmpty()) return false;
                else if (st.peek() == '(') st.pop();
            }
        }
        if (st.isEmpty()) return true;
        else return false;
    }
}