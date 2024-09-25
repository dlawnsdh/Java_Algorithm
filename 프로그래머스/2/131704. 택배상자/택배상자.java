import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> st = new Stack<>();
        int idx = 0;
        int count = 0;
        for (int box = 1; box <= order.length;) {
            if (order[idx] == box) {
                count++;
                box++;
                idx++;
            } else if (!st.isEmpty() && st.peek() == order[idx]) {
                count++;
                idx++;
                st.pop();
            } else st.push(box++);
        }
        while (!st.isEmpty()) {
            if (order[idx] == st.pop()) {
                idx++;
                count++;
            } else break; 
        }
        return count;
    }
}