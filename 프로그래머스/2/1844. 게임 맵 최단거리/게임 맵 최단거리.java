import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[][] dist = new int[maps.length][maps[0].length];
        LinkedList<int[]> q = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for (int i = 0; i < maps.length; i++)
            Arrays.fill(dist[i], -1);
        dist[0][0] = 1;
        q.add(new int[] {0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) continue;
                if (dist[nx][ny] >= 0 || maps[nx][ny] == 0) continue;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.add(new int[] {nx, ny});
            }
        }
        return dist[maps.length - 1][maps[0].length - 1];
    }
}