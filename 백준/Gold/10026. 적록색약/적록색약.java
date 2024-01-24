import java.util.*;
import java.io.*;

public class Main {
    public static char[][] map = new char[100][100];
    public static boolean[][][] visited = new boolean[100][100][2];
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    
    public static void bfs(int n, int x, int y, char color, boolean flag) {
        LinkedList<int[]> q = new LinkedList<>();
        if (flag) visited[x][y][1] = true;
        else visited[x][y][0] = true;
        q.add(new int[] {x, y});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (flag) {
                    if (!visited[nx][ny][1] && (map[nx][ny] == color || ((color == 'G' && map[nx][ny] == 'R') || (color == 'R' && map[nx][ny] == 'G')))) {
                        visited[nx][ny][1] = true;
                        q.add(new int[] {nx, ny});
                    }
                } else {
                    if (!visited[nx][ny][0] && map[nx][ny] == color) {
                        visited[nx][ny][0] = true;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int k = 0; k < n; k++)
                map[i][k] = s.charAt(k);
        }
        
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < n; i++)
            for (int k = 0; k < n; k++) {
                if (!visited[i][k][0]) {
                    cnt1++;
                    bfs(n, i, k, map[i][k], false);
                }
                if (!visited[i][k][1]) {
                    cnt2++;
                    bfs(n, i, k, map[i][k], true);
                }
            }
        System.out.println(cnt1 + " " + cnt2);
    }
}