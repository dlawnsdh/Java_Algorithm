import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < m; k++)
                map[i][k] = Integer.parseInt(st.nextToken());
        }
        
        int cnt = 0;
        LinkedList<int[]> q = new LinkedList<>();
        int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
        int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};
        for (int i = 0; i < n; i++)
            for (int k = 0; k < m; k++)
                if (!visited[i][k] && map[i][k] == 1) {
                    cnt++;
                    visited[i][k] = true;
                    q.add(new int[] {i, k});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int j = 0; j < 8; j++) {
                            int nx = cur[0] + dx[j];
                            int ny = cur[1] + dy[j];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (visited[nx][ny] || map[nx][ny] == 0) continue;
                            visited[nx][ny] = true;
                            q.add(new int[] {nx, ny});
                        }
                    }
                }
        System.out.print(cnt);
    }
}