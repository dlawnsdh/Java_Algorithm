import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer[]> q = new LinkedList<>();
        int t = sc.nextInt();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        for (int l = 0; l < t; l++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            boolean[][] visited = new boolean[n][m];
            int[][] map = new int[n][m];
            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;
            }
            
            int cnt = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++) 
                    if (map[i][j] == 1 && !visited[i][j]) {
                        q.add(new Integer[] {i, j});
                        visited[i][j] = true;
                        while (!q.isEmpty()) {
                            int x = q.peek()[0];
                            int y = q.peek()[1];
                            q.poll();
                            for (int a = 0; a < 4; a++) {
                                int nx = x + dx[a];
                                int ny = y + dy[a];
                                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                                if (visited[nx][ny] || map[nx][ny] == 0) continue;
                                visited[nx][ny] = true;
                                q.add(new Integer[] {nx, ny});
                            }
                        }
                        cnt++;
                    }
            System.out.println(cnt);
        }
    }
}