import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int idx = 0;
        int min = n;
        while (idx < wires.length) {
            List<List<Integer>> g = new ArrayList<>();
            for (int i = 0; i <= n; i++)
                g.add(new ArrayList<>());
            for (int i = 0; i < wires.length; i++)
                if (i != idx) {
                    g.get(wires[i][0]).add(wires[i][1]);
                    g.get(wires[i][1]).add(wires[i][0]);
                }
            
            LinkedList<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];
            List<Integer> count = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    int cnt = 1;
                    q.add(i);
                    visited[i] = true;
                    while (!q.isEmpty()) {
                        int cur = q.poll();
                        for (int k = 0; k < g.get(cur).size(); k++) {
                            int x = g.get(cur).get(k);
                            if (!visited[x]) {
                                visited[x] = true;
                                q.add(x);
                                cnt++;
                            }
                        }
                    }
                    count.add(cnt);
                }    
            }
            min = Math.min(min, Math.abs(count.get(0) - count.get(1)));
            idx++;
        }
        return min;
    }
}