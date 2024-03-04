import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        if ((sum1 + sum2) % 2 != 0) return -1;

        int start = 0;
        int end = q1.size() * 3;
        int cnt = 0;
        while (start < end) {
            if (sum1 > sum2) { 
                q2.add(q1.poll());
                sum1 -= q2.getLast();
                sum2 += q2.getLast();
            } else if (sum1 < sum2) {
                q1.add(q2.poll());
                sum1 += q1.getLast();
                sum2 -= q1.getLast();
            } else return cnt;
            start++;
            cnt++;
        }
        return -1;
    }
}