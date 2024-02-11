import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        PriorityQueue<Integer> q2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].charAt(0) == 'I') {
                q1.add(Integer.parseInt(operations[i].substring(2)));
                q2.add(Integer.parseInt(operations[i].substring(2)));
            } else if (operations[i].equals("D -1") && !q1.isEmpty()) {
                q2.remove(q1.poll());
            } else if (operations[i].equals("D 1") && !q2.isEmpty()) {
                q1.remove(q2.poll());    
            }
        }
        return q1.isEmpty() || q2.isEmpty() ? new int[] {0, 0} : new int[] {q2.poll(), q1.poll()};
    }
}