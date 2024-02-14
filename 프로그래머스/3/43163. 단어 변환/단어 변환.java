import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {        
        int[] dist = new int[words.length + 1];
        LinkedList<String> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        List<String> l = new ArrayList<>(Arrays.asList(words));
        l.add(0, begin);
        
        Arrays.fill(dist, -1);
        q1.add(begin);
        q2.add(0);
        dist[0] = 0;
        while (!q1.isEmpty()) {
            String cur = q1.poll();
            int idx = q2.poll();
            if (cur.equals(target))
                return dist[l.indexOf(target)];
            
            for (int i = 1; i < l.size(); i++) {
                String next = l.get(i);
                if (dist[i] > 0) continue;
                int cnt = 0;
                for (int k = 0; k < next.length(); k++)
                    if (next.charAt(k) != cur.charAt(k))
                        cnt++;
                if (cnt == 1) {
                    dist[i] = dist[idx] + 1;
                    q1.add(next);
                    q2.add(i);
                }
            }
        }
        return 0;
    }
}