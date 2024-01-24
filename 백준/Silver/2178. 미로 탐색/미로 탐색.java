import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]); 
        int m = Integer.parseInt(arr[1]);
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();    
            for (int k = 0; k < m; k++)
                map[i][k] = s.charAt(k) - 48;
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] xy = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];
                if (nx < 0 | nx >= n || ny < 0 || ny >= m)
                    continue;
                if (visited[nx][ny] || map[nx][ny] == 0)
                    continue;
                visited[nx][ny] = true;
                map[nx][ny] = map[xy[0]][xy[1]] + 1;
                q.add(new int[] {nx, ny});
            }
        }
        System.out.print(map[n - 1][m - 1]);
    }
}