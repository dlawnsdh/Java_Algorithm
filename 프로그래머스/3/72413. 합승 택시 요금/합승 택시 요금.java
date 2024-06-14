import java.util.*;

class Solution {
    List<List<int[]>> g = new ArrayList<>();
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int[] f : fares) {
            g.get(f[0]).add(new int[] {f[1], f[2]});
            g.get(f[1]).add(new int[] {f[0], f[2]});
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int stoi = calculateFee(new int[n + 1], new boolean[n + 1], s, i);
            int itoa = calculateFee(new int[n + 1], new boolean[n + 1], i, a);
            int itob = calculateFee(new int[n + 1], new boolean[n + 1], i, b);
            min = Math.min(min, stoi + itoa + itob);
        }
        return min;
    }
    
    public int calculateFee(int[] dist, boolean[] visited, int st, int en) {
        PriorityQueue<int[]> q = new PriorityQueue<>((arr1, arr2) -> arr1[1] - arr2[1]);
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[st] = 0;
        q.add(new int[] {st, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (visited[cur[0]]) 
                continue;
            visited[cur[0]] = true;
            if (cur[0] == en) 
                break;
            for (int i = 0; i < g.get(cur[0]).size(); i++) {
                int[] nx = g.get(cur[0]).get(i);
                if (dist[nx[0]] > dist[cur[0]] + nx[1]) { 
                    dist[nx[0]] = dist[cur[0]] + nx[1];
                    q.add(new int[] {nx[0], dist[nx[0]]});
                }
            }
        }
        return dist[en];
    }
}