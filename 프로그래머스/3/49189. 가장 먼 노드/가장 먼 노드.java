import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int[] e : edge) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < g.get(cur).size(); i++) {
                int nx = g.get(cur).get(i);
                if (dist[nx] < 0) {
                    dist[nx] = dist[cur] + 1;
                    q.add(nx);
                }
            }
        }
        
        Arrays.sort(dist);
        return (int) Arrays.stream(dist)
            .filter(d -> d == dist[n])
            .count();
    }
}