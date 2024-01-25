import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, 2, -2, -2, 2, 1, -1};
        for (int i = 0; i < t; i++) {
            LinkedList<int[]> q = new LinkedList<>();
            int n = Integer.parseInt(br.readLine());
            String[] start = br.readLine().split(" ");
            String[] end = br.readLine().split(" ");
            int[][] dist = new int[n][n];
            for (int k = 0; k < n; k++)
                Arrays.fill(dist[k], -1);
            
            dist[Integer.parseInt(start[0])][Integer.parseInt(start[1])] = 0;
            q.add(new int[] {Integer.parseInt(start[0]), Integer.parseInt(start[1])});
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                if (cur[0] == Integer.parseInt(end[0]) && cur[1] == Integer.parseInt(end[1])) {
                    System.out.println(dist[cur[0]][cur[1]]);
                    break;
                }
                for (int k = 0; k < 8; k++) {
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (dist[nx][ny] >= 0) continue;
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                    q.add(new int[] {nx, ny});
                }
            }
        }
    }
}