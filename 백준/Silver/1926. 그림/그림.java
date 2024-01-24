import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int m = sc.nextInt();
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int k = 0; k < m; k++)
                map[i][k] = sc.nextInt();
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        LinkedList<int[]> q = new LinkedList<>();
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++)
            for (int k = 0; k < m; k++) {
                if (!visited[i][k] && map[i][k] == 1) {
                    cnt++;
                    q.add(new int[] {i, k});
                    visited[i][k] = true;
                    while (!q.isEmpty()) {
                        int[] xy = q.poll();
                        for (int j = 0; j < 4; j++) {
                            int nx = xy[0] + dx[j];
                            int ny = xy[1] + dy[j];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                                continue;
                            if (visited[nx][ny] || map[nx][ny] == 0)
                                continue;
                            visited[nx][ny] = true;
                            map[i][k]++;
                            q.add(new int[] {nx, ny});
                        }
                    }
                }
                max = Math.max(max, map[i][k]);
            }
        System.out.println(cnt);
        System.out.println(max);
    }
}