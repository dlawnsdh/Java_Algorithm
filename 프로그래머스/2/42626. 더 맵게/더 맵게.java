import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i : scoville)
            q.add(i);
        if (q.peek() >= K) return 0;
        
        int cnt = 0;
        while (q.size() > 1) {
            cnt++;
            int min1 = q.poll();
            int min2 = q.poll();
            q.add(min1 + min2 * 2);
            if (q.peek() >= K)
                return cnt;
        }
        return -1;
    }
}