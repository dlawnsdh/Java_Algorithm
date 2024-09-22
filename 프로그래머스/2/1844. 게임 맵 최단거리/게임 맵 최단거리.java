import java.util.*;

class Solution {
    int bfs(int[][] map, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], -1);
        
        dist[0][0] = 1;
        q.add(new int[] {0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (dist[nx][ny] >= 0 || map[nx][ny] == 0) continue;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.add(new int[] {nx, ny});
            }
        }
        return dist[n - 1][m - 1];
    }
    
    public int solution(int[][] maps) {
        return bfs(maps, maps.length, maps[0].length);
    }
}