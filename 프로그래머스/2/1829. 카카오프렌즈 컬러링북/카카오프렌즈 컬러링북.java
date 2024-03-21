import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        LinkedList<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] dist = new int[m][n];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < m; i++)
            for (int k = 0; k < n; k++)
                if (!visited[i][k] && picture[i][k] > 0) {
                    int color = picture[i][k];
                    numberOfArea++;
                    dist[i][k] = 1;
                    visited[i][k] = true;
                    q.add(new int[] {i, k});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int j = 0; j < 4; j++) {
                            int nx = cur[0] + dx[j];
                            int ny = cur[1] + dy[j];
                            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                            if (visited[nx][ny] || picture[nx][ny] == 0 || picture[nx][ny] != color) continue;
                            dist[i][k]++;
                            visited[nx][ny] = true;
                            q.add(new int[] {nx, ny});
                        }
                    }
                    maxSizeOfOneArea = Math.max(dist[i][k], maxSizeOfOneArea);
                }
        return new int[] {numberOfArea, maxSizeOfOneArea};
    }
}