import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        List<Integer> l = new ArrayList<>();
        LinkedList<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int[][] dist = new int[maps.length][maps[0].length()];
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1}; 
        for (int i = 0; i < maps.length; i++)
            for (int k = 0; k < maps[i].length(); k++)
                if (maps[i].charAt(k) != 'X' && !visited[i][k]) {
                    visited[i][k] = true;
                    dist[i][k] = maps[i].charAt(k) - 48;
                    q.add(new int[] {i, k});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int j = 0; j < 4; j++) {
                            int nx = cur[0] + dx[j];
                            int ny = cur[1] + dy[j];
                            if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length()) continue;
                            if (visited[nx][ny] || maps[nx].charAt(ny) == 'X') continue;
                            visited[nx][ny] = true;
                            dist[i][k] += maps[nx].charAt(ny) - 48;
                            q.add(new int[] {nx, ny});
                        }
                    }
                    l.add(dist[i][k]);
                }
        
        return l.size() == 0 ? new int[] {-1} : l.stream().sorted()
            .mapToInt(Integer::intValue).toArray();
    }
}