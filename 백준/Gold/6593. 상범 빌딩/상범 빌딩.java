import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        int[] end = new int[3];
        
        while (l != 0 && r != 0 && c != 0) {
            int[][][] map = new int[l][r][c];
            int[][][] dist = new int[l][r][c];
            LinkedList<int[]> q = new LinkedList<>();
            for (int i = 0; i < l; i++) {
                for (int k = 0; k < r; k++) {
                    String s = br.readLine();
                    for (int j = 0; j < c; j++) {
                        map[i][k][j] = s.charAt(j);
                        dist[i][k][j] = -1;
                        if (map[i][k][j] == 'S') {
                            q.add(new int[] {i, k, j});
                            dist[i][k][j] = 0;
                        } else if (map[i][k][j] == 'E')
                            end = new int[] {i, k, j};
                    }
                }
                br.readLine();
            }
            
            boolean flag = true;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                if (cur[0] == end[0] && cur[1] == end[1] && cur[2] == end[2]) {
                    System.out.printf("Escaped in %d minute(s).\n", dist[cur[0]][cur[1]][cur[2]]);
                    flag = false;
                    break;
                }
                for (int i = 0; i < 6; i++) {
                    int nz = cur[0] + dz[i];
                    int nx = cur[1] + dx[i];
                    int ny = cur[2] + dy[i];
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c || nz < 0 || nz >= l) continue;
                    if (dist[nz][nx][ny] >= 0 || map[nz][nx][ny] == '#') continue;
                    dist[nz][nx][ny] = dist[cur[0]][cur[1]][cur[2]] + 1;
                    q.add(new int[] {nz, nx, ny});
                }
            }
            if (flag) System.out.println("Trapped!");
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
    }
}