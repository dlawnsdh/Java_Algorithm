import java.util.*;
import java.util.*;

class Solution {
    int max = 0;
    
    public int solution(int n, int[][] edge) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int i = 0; i < edge.length; i++) {
            g.get(edge[i][0]).add(edge[i][1]);
            g.get(edge[i][1]).add(edge[i][0]);
        }
        
        LinkedList<Integer> q = new LinkedList<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < g.get(cur).size(); i++) {
                int x = g.get(cur).get(i);
                if (dist[x] >= 0) continue;
                dist[x] = dist[cur] + 1;
                max = Math.max(max, dist[x]);
                q.add(x);
            }
        }
        
        return (int) Arrays.stream(dist).filter(i -> i == max).count();
    }
}