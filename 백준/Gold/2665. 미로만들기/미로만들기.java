import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int k = 0; k < n; k++)
                arr[i][k] = str.charAt(k) - 48;
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], -1);
        
        dist[0][0] = 0;
        pq.add(new int[] {0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || dist[nx][ny] >= 0) 
                    continue;
                if (arr[nx][ny] == 0)
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                else dist[nx][ny] = dist[cur[0]][cur[1]];
                pq.add(new int[] {nx, ny, dist[nx][ny]});
            }
        }
        System.out.print(dist[n - 1][n - 1]);
    }
}