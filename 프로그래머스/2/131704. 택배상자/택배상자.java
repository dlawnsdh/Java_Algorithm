import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> s = new Stack<>();
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 1; i <= order.length; i++)
            q.add(i);
          
        int sum = 0;
        int idx = 0;
        while (!q.isEmpty()) {
            if (order[idx] == q.peek()) {
                sum++;
                idx++;
                q.poll();
            } else {
                if (!s.isEmpty() && order[idx] == s.peek()) {
                    sum++;
                    idx++;
                    s.pop();
                } else s.push(q.poll());
            }
        }
        while (!s.isEmpty()) {
            if (order[idx] == s.pop()) {
                idx++;
                sum++;
            }
            else break;
        }
        return sum;
    }
}