import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int w : works)
            pq.add(w);
        while (n-- > 0 && !pq.isEmpty()) {
            if (pq.peek() > 1)
                pq.add(pq.poll() - 1);
            else pq.poll();
        }
        long sum = 0;
        while (!pq.isEmpty())
            sum += Math.pow(pq.poll(), 2);
        return sum;
    }
}