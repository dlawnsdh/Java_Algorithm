import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>();
        for (int i = 0;  i < A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
        }
        
        int count = 0;
        while (!b.isEmpty()) {
            if (b.peek() > a.peek()) {
                a.poll();
                count++;
            }
            b.poll();
        }
        return count;
    }
}