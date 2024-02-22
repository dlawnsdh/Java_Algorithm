import java.util.*;

class Solution {
    public int bfs(char[][] map, int[][] dist, int[] start, char end) {
        LinkedList<int[]> q = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < dist.length; i++)
            Arrays.fill(dist[i], -1);
        
        q.add(start);
        dist[start[0]][start[1]] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (map[cur[0]][cur[1]] == end)
                return dist[cur[0]][cur[1]];
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                if (dist[nx][ny] >= 0 || map[nx][ny] == 'X') continue;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.add(new int[] {nx, ny});
            }
        }
        return -1;
    }
    
    public int solution(String[] maps) {
        char[][] map = new char[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] lever = new int[2];
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
            for (int k = 0; k < maps[i].length(); k++) {
                if (maps[i].charAt(k) == 'S') {
                    start[0] = i;
                    start[1] = k;
                }
                if (maps[i].charAt(k) == 'L') {
                    lever[0] = i;
                    lever[1] = k;
                }
            }
        }
        
        int l = bfs(map, new int[map.length][map[0].length], start, 'L');
        int e = bfs(map, new int[map.length][map[0].length], lever, 'E');
        return l == -1 || e == -1 ? -1 : l + e;
    }
}