import java.util.*;

class Solution {
    int bfs(List<List<Integer>> g) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[g.size()];
        visited[1] = true;
        q.add(1);
        int count = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < g.get(cur).size(); i++) {
                int nx = g.get(cur).get(i);
                if (!visited[nx]) {
                    visited[nx] = true;
                    q.add(nx);
                    count++;
                }
            }
        }
        int rest = g.size() - count - 1;
        return Math.abs(rest - count);
    }
    
    public int solution(int n, int[][] wires) {
        int min = 100;
        for (int remove = 0; remove < wires.length; remove++) {
            List<List<Integer>> g = new ArrayList<>();
            for (int i = 0; i <= n; i++)
                g.add(new ArrayList<>());
            for (int i = 0; i < wires.length; i++) {
                if (i == remove) continue;
                g.get(wires[i][0]).add(wires[i][1]);
                g.get(wires[i][1]).add(wires[i][0]);
            }
            
            min = Math.min(min, bfs(g));
        }
        return min;
    }
}