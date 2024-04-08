import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int round = 0;
        for (int i = 0; i < enemy.length; i++) {
            q.add(enemy[i]);
            if (k <= i)
                n -= q.poll();
            if (n < 0) 
                return round;
            round++;
        }
        return round;
    }
}