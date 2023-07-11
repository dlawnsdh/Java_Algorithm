import java.util.*;
import java.io.*;

public class Main {
    public static int bfs(int[][] map, int n, int m) {
        Queue<Integer[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        q.add(new Integer[] {0, 0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] || map[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                map[nx][ny] += map[x][y];
                q.add(new Integer[] {nx, ny});
                if (nx == n - 1 && ny == m - 1)
                    return map[n - 1][m - 1];
            }
        }
        return map[n - 1][m - 1];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int k = 0; k < s.length(); k++)
                map[i][k] = s.charAt(k) - 48;
        }
        
        System.out.print(bfs(map, n, m));
    }
}