import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            char[][] map = new char[n][m];
            int[][] dist1 = new int[n][m];
            int[][] dist2 = new int[n][m];
            
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            LinkedList<int[]> q1 = new LinkedList<>();
            LinkedList<int[]> q2 = new LinkedList<>();
            for (int k = 0; k < n; k++) {
                String s = br.readLine();
                for (int j = 0; j < m; j++) {
                    dist1[k][j] = -1;
                    dist2[k][j] = -1;
                    map[k][j] = s.charAt(j);
                    if (map[k][j] == '*') {
                        q1.add(new int[] {k, j});
                        dist1[k][j] = 0;
                    }
                    if (map[k][j] == '@') {
                        q2.add(new int[] {k, j});
                        dist2[k][j] = 0;
                    }
                }
            }
            
            while(!q1.isEmpty()) {
                int[] cur = q1.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (dist1[nx][ny] >= 0 || map[nx][ny] == '#') continue;
                    dist1[nx][ny] = dist1[cur[0]][cur[1]] + 1;
                    q1.add(new int[] {nx, ny});
                }
            }
            
            boolean flag = true;
            Outer: while(!q2.isEmpty()) {
                int[] cur = q2.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        System.out.println(dist2[cur[0]][cur[1]] + 1);
                        flag = false;
                        break Outer;
                    }
                    if (dist2[nx][ny] >= 0 || map[nx][ny] == '#') continue;
                    if (dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cur[0]][cur[1]] + 1) continue;
                    dist2[nx][ny] = dist2[cur[0]][cur[1]] + 1;
                    q2.add(new int[] {nx, ny});
                }
            }
            if (flag) System.out.println("IMPOSSIBLE");
        }
    }
}