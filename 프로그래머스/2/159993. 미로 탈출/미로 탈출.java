import java.util.*;

class Solution {
    public int solution(String[] maps) {
        char[][] map = new char[maps.length][maps[0].length()];
        int[][] dist = new int[maps.length][maps[0].length()];
        LinkedList<int[]> q = new LinkedList<>();
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
            Arrays.fill(dist[i], -1);
            for (int k = 0; k < maps[i].length(); k++)
                if (maps[i].charAt(k) == 'S') {
                    q.add(new int[] {i, k});
                    dist[i][k] = 0;
                }
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int distL = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (map[cur[0]][cur[1]] == 'L') {
                q.clear();
                q.add(cur);
                distL = dist[cur[0]][cur[1]];
                for (int i = 0; i < dist.length; i++)
                    Arrays.fill(dist[i], -1);
                dist[cur[0]][cur[1]] = 0;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                if (dist[nx][ny] >= 0 || map[nx][ny] == 'X') continue;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.add(new int[] {nx, ny});
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (map[cur[0]][cur[1]] == 'E') 
                return dist[cur[0]][cur[1]] + distL;
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
}