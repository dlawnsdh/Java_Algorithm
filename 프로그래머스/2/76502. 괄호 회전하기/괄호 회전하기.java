import java.util.*;

class Solution {
    public int solution(String s) {
        int n = 0;
        int cnt = 0;
        LinkedList<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++)
            q.add(s.charAt(i));
        
        while (n < s.length()) {
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < q.size(); i++) {
                if (q.get(i) == '(' || q.get(i) == '{' || q.get(i) == '[')
                    st.push(q.get(i));
                else {
                    if (!st.isEmpty() && ((st.peek() == '(' && q.get(i) == ')') || (st.peek() == '{' && q.get(i) == '}') || (st.peek() == '[' && q.get(i) == ']')))
                        st.pop();
                    else st.push(q.get(i));
                }
            }
            if (st.isEmpty()) cnt++;
            q.add(q.poll());
            n++;
        }
        return cnt;
    }
}