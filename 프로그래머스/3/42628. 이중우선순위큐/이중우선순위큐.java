import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a);
        
        for (String op : operations) {
            if (op.charAt(0) == 'I') {
                int num = Integer.parseInt(op.substring(2));
                minQ.add(num);
                maxQ.add(num);
            } else if (op.charAt(2) == '1' && !maxQ.isEmpty())
                minQ.remove(maxQ.poll());
            else if (op.charAt(2) == '-' && !minQ.isEmpty())
                maxQ.remove(minQ.poll());
        }
        return minQ.isEmpty() || maxQ.isEmpty() ? new int[] {0, 0} : new int[] {maxQ.peek(), minQ.peek()};
    }
}