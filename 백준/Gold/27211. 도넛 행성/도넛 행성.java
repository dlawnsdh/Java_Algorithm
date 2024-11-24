import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < m; k++)
                map[i][k] = Integer.parseInt(st.nextToken());
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int k = 0; k < m; k++)
                if (!visited[i][k] && map[i][k] == 0) {
                    visited[i][k] = true;
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, k});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int j = 0; j < 4; j++) {
                            int nx = cur[0] + dx[j];
                            int ny = cur[1] + dy[j];
                            if (nx < 0) nx = n - 1;
                            else if (nx >= n) nx = 0;
                            if (ny < 0) ny = m - 1;
                            else if (ny >= m) ny = 0;
                            if (!visited[nx][ny] && map[nx][ny] == 0) {
                                visited[nx][ny] = true;
                                q.add(new int[] {nx, ny});
                            }
                        }
                    }
                }
        System.out.print(count);
    }
}