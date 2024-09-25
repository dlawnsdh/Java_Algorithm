import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<int[]> st = new Stack<>();
        int[] arr = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            while (!st.isEmpty() && st.peek()[0] > prices[i]) {
                int[] cur = st.pop();
                arr[cur[1]] += i - cur[1];
            }
            st.push(new int[] {prices[i], i});
        }
        int lastIdx = st.pop()[1];
        while (!st.isEmpty()) {
            int[] cur = st.pop();
            arr[cur[1]] += lastIdx - cur[1];
        }
        return arr;
    }
}