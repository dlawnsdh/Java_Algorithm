import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            LinkedList<int[]> q = new LinkedList<>();
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            
            int cnt = 0;
            for (int h = 0; h < n; h++)
                for (int g = 0; g < m; g++) {
                    if (!visited[h][g] && map[h][g] == 1) {
                        cnt++;
                        visited[h][g] = true;
                        q.add(new int[] {h, g});
                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            for (int u = 0; u < 4; u++) {
                                int nx = cur[0] + dx[u];
                                int ny = cur[1] + dy[u];
                                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                                if (visited[nx][ny] || map[nx][ny] == 0) continue;
                                visited[nx][ny] = true;
                                q.add(new int[] {nx, ny});
                            }
                        }
                    }
                }
            System.out.println(cnt);
        }
    }
}