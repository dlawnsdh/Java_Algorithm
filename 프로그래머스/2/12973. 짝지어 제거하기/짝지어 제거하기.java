import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!st.isEmpty() && st.peek() == s.charAt(i)) st.pop();
            else st.push(s.charAt(i));
        }
        return st.isEmpty() ? 1 : 0;
    }
}