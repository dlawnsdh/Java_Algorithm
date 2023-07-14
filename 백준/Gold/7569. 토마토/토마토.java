import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();
        int[][][] map = new int[h][n][m];
        int[][][] dist = new int[h][n][m];
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        
        Queue<Integer[]> q = new LinkedList<>();
        for (int i = 0; i < h; i++)
            for (int k = 0; k < n; k++)
                for (int j = 0; j < m; j++) {
                    map[i][k][j] = sc.nextInt();
                    if (map[i][k][j] == 1)
                        q.add(new Integer[] {i, k, j});
                    if (map[i][k][j] == 0)
                        dist[i][k][j] = -1;
                }
        
        while (!q.isEmpty()) {
            int x = q.peek()[1];
            int y = q.peek()[2];
            int z = q.peek()[0];
            q.poll();
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) 
                    continue;
                if (dist[nz][nx][ny] > -1) continue;
                dist[nz][nx][ny] = dist[z][x][y] + 1;
                q.add(new Integer[]{nz, nx, ny});
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < h; i++)
            for (int k = 0; k < n; k++)
                for (int j = 0; j < m; j++) {
                    if (dist[i][k][j] == -1) {
                        System.out.print(-1);
                        return;
                    }
                    cnt = Math.max(cnt, dist[i][k][j]);
                }
        System.out.print(cnt);
    }
}