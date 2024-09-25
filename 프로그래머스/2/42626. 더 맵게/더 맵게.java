import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville)
            pq.add(s);
        
        int count = 0;
        while (pq.size() > 1) {
            if (pq.peek() >= K)
                return count;
            pq.add(pq.poll() + pq.poll() * 2);
            count++;
        }
        return pq.poll() >= K ? count : -1;
    }
}