import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int k = 0; k < m; k++)
                map[i][k] = s.charAt(k);
        }
        
        int max = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[][] dist = new int[n][m];
        LinkedList<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            for (int k = 0; k < m; k++) {
                if (map[i][k] == 'L') {
                    dist[i][k] = 1;
                    q.add(new int[] {i, k});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int j = 0; j < 4; j++) {
                            int nx = cur[0] + dx[j];
                            int ny = cur[1] + dy[j];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (dist[nx][ny] > 0 || map[nx][ny] == 'W') continue;
                            dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                            max = Math.max(max, dist[nx][ny]);
                            q.add(new int[] {nx, ny});
                        }
                    }
                }
                dist = new int[n][m];
            }
        System.out.print(max - 1);
    }
}