import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[][] map = new int[m][n];
        Queue<Integer[]> q = new LinkedList<>();
        int[][] dist = new int[m][n];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < m; i++)
            for (int k = 0; k < n; k++) {
                map[i][k] = sc.nextInt();
                if (map[i][k] == 1)
                    q.add(new Integer[] {i, k});
                else if (map[i][k] == 0)
                    dist[i][k] = -1;
            }
        
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (dist[nx][ny] > -1) continue;
                q.add(new Integer[] {nx, ny});
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++)
            for (int k = 0; k < n; k++) {
                if (dist[i][k] == -1) {
                    System.out.print(-1);
                    return;
                }
                cnt = Math.max(cnt, dist[i][k]);
            }
        System.out.print(cnt);
    }
}