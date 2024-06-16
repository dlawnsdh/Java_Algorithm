import java.util.*;

class Solution {
    List<List<Integer>> g = new ArrayList<>();
    
    public int bfs(int source, int destination) {
        Queue<int[]> q = new LinkedList<>();
        int[] dist = new int[g.size()];
        boolean[] visited = new boolean[g.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
            
        dist[source] = 0;
        visited[source] = true;
        q.add(new int[] {source, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == destination)
                return dist[destination];
            for (int k = 0; k < g.get(cur[0]).size(); k++) {
                int nx = g.get(cur[0]).get(k);
                if (visited[nx]) continue;
                if (dist[nx] > dist[cur[0]] + 1) {
                    visited[nx] = true;
                    dist[nx] = dist[cur[0]] + 1;
                    q.add(new int[] {nx, dist[nx]});
                }
                if (nx == destination)
                    return dist[destination];
            }
        }
        return -1;
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int[] road : roads) {
            g.get(road[0]).add(road[1]);
            g.get(road[1]).add(road[0]);
        }   
        
        int[] result = new int[sources.length];
        for (int i = 0; i < sources.length; i++)
            result[i] = bfs(sources[i], destination);
        
        return result;
    }
}