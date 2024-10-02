import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> st = new Stack<>();
        int remove = 0;
        for (char n : number.toCharArray()) {
            while (!st.isEmpty() && st.peek() < n - 48 && remove++ < k)
                st.pop();
            st.push(n - 48);
        }
        
        StringBuilder sb = new StringBuilder();
        while (st.size() > number.length() - k)
            st.pop();
        while (!st.isEmpty())
            sb.append(st.pop());
        return sb.reverse().toString();
    }
}