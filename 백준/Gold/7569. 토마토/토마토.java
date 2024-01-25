import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); 
        int n = Integer.parseInt(st.nextToken()); 
        int h = Integer.parseInt(st.nextToken());
        int[][][] box = new int[h][n][m];
        int[][][] dist = new int[h][n][m];
        LinkedList<int[]> q = new LinkedList<>();
        for (int i = 0; i < h; i++)
            for (int k = 0; k < n; k++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    dist[i][k][j] = -1;
                    box[i][k][j] = Integer.parseInt(st.nextToken());
                    if (box[i][k][j] == 1) {
                        q.add(new int[] {k, j, i});
                        dist[i][k][j] = 0;
                    }
                }
            }
        
        int[] dx = {0, 0, 1, -1, 0, 0};
        int[] dy = {1, -1, 0, 0, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        int max = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 6; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int nz = cur[2] + dz[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) continue;
                if (dist[nz][nx][ny] >= 0 || box[nz][nx][ny] == -1) continue;
                dist[nz][nx][ny] = dist[cur[2]][cur[0]][cur[1]] + 1;
                max = Math.max(max, dist[nz][nx][ny]);
                q.add(new int[] {nx, ny, nz});
            }
        }
        
        for (int i = 0; i < h; i++)
            for (int k = 0; k < n; k++)
                for (int j = 0; j < m; j++) {
                    if (dist[i][k][j] == -1 && box[i][k][j] == 0) {
                        System.out.print(-1);
                        return;
                    }
                }
        System.out.print(max);
    }
}