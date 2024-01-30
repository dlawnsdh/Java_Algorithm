import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int k = (100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1;
            q.add(k);
        }
        
        List<Integer> l = new ArrayList<>();
        int max = q.poll();
        int cnt = 1;
        if (q.isEmpty()) return new int[] {cnt};
        while (!q.isEmpty()) {
            if (max < q.peek()) {
                max = q.poll();
                l.add(cnt);
                cnt = 1;
            } else {
                cnt++;
                q.poll();
            }
        }
        l.add(cnt);
        return l.stream().mapToInt(Integer::intValue).toArray();
    }
}