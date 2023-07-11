import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        Queue<Integer[]> q = new LinkedList<>();
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < n; i++)
            for (int k = 0; k < m; k++)
                map[i][k] = sc.nextInt();
        
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++)
            for (int k = 0; k < m; k++) 
                if (map[i][k] == 1 && !visited[i][k]) {
                    Integer[] arr = {i, k};
                    q.add(arr);
                    visited[i][k] = true;
                    int sum = 1;

                    while (!q.isEmpty()) {
                        int x = q.peek()[0];
                        int y = q.peek()[1];
                        q.poll();
                        for (int j = 0; j < 4; j++) {
                            int nx = x + dx[j];
                            int ny = y + dy[j];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (visited[nx][ny] || map[nx][ny] == 0) continue;
                            visited[nx][ny] = true;
                            q.add(new Integer[] {nx, ny});
                            sum++;
                        }
                    }
                    max = Math.max(max, sum);
                    if (sum != 0)
                        cnt++;
                }
        System.out.print(cnt + "\n" + max);
    }
}