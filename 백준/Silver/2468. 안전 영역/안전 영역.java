import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer[]> q = new LinkedList<>();
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int max = 0;
        for (int i = 0; i < n; i++)
            for (int k = 0; k < n; k++) {
                map[i][k] = sc.nextInt();
                max = Math.max(max, map[i][k]);
            }
        
        int cnt = 0;
        for (int h = 0; h < max; h++) {
            boolean[][] visited = new boolean[n][n];
            int sum = 0;
            for (int i = 0; i < n; i++)
                for (int k = 0; k < n; k++)
                    if (map[i][k] > h && !visited[i][k]) {
                        visited[i][k] = true;
                        q.add(new Integer[] {i, k});
                        while (!q.isEmpty()) {
                            int x = q.peek()[0];
                            int y = q.peek()[1];
                            q.poll();
                            for (int j = 0; j < 4; j++) {
                                int nx = x + dx[j];
                                int ny = y + dy[j];
                                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                                if (map[nx][ny] <= h || visited[nx][ny]) continue;
                                visited[nx][ny] = true;
                                q.add(new Integer[] {nx, ny});
                            }
                        }
                        sum++;
                    }
            cnt = Math.max(cnt, sum);
        }
        System.out.print(cnt);
    }
}