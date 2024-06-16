import java.util.*;
import java.io.*;

public class Main {
    static int INF = 200000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int k = 0; k < m; k++)
                map[i][k] = str.charAt(k) - 48;
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], INF);
        
        dist[0][0] = 0;
        pq.add(new int[] {0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == n - 1 && cur[1] == m - 1)
                break;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) 
                    continue;
                int cost = map[nx][ny];
                if (dist[nx][ny] > dist[cur[0]][cur[1]] + cost) {
                    dist[nx][ny] = dist[cur[0]][cur[1]] + cost;
                    pq.add(new int[] {nx, ny, dist[nx][ny]});
                }
            }
        }
        System.out.print(dist[n - 1][m - 1]);
    }
}