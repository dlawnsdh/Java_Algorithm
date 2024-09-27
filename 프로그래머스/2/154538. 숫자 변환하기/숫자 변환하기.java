import java.util.*;

class Solution {
    int bfs(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[y + 1];
        Arrays.fill(dist, -1);
        
        dist[x] = 0;
        q.add(x);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == y)
                return dist[y];
            if (cur + n <= y && dist[cur + n] < 0) {
                dist[cur + n] = dist[cur] + 1;
                q.add(cur + n);
            }
            if (cur * 2 <= y && dist[cur * 2] < 0) {
                dist[cur * 2] = dist[cur] + 1;
                q.add(cur * 2);
            }
            if (cur * 3 <= y && dist[cur * 3] < 0) {
                dist[cur * 3] = dist[cur] + 1;
                q.add(cur * 3);
            }
        }
        return -1;
    } 
    
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }
}