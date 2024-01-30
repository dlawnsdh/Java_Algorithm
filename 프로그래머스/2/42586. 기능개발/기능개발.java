import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) 
            q.add((100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1);
        
        List<Integer> l = new ArrayList<>();
        int max = q.poll();
        int cnt = 1;
        if (q.isEmpty()) return new int[] {cnt};
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (max < cur) {
                max = cur;
                l.add(cnt);
                cnt = 1;
            } else cnt++;
        }
        l.add(cnt);
        return l.stream().mapToInt(Integer::intValue).toArray();
    }
}