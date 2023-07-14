import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        
        while (true) {
            String[] arr = br.readLine().split(" ");
            int l = Integer.parseInt(arr[0]); 
            int r = Integer.parseInt(arr[1]); 
            int c = Integer.parseInt(arr[2]);
            if (l == 0 && r == 0 && c == 0) return;
            
            char[][][] map = new char[l][r][c];
            int[][][] dist = new int[l][r][c];
            Queue<Integer[]> q = new LinkedList<>();
            int[] goal = new int[3];
            for (int i = 0; i < l; i++) {
                for (int k = 0; k < r; k++) {
                    String str = br.readLine();
                    for (int j = 0; j < c; j++) {
                        map[i][k][j] = str.charAt(j);
                        if (map[i][k][j] == 'S')
                            q.add(new Integer[] {i, k, j});
                        if (map[i][k][j] == 'E')
                            goal = new int[] {i, k, j};
                    }
                }
                br.readLine();
            }
            
            while (!q.isEmpty()) {
                int x = q.peek()[1];
                int y = q.peek()[2];
                int z = q.peek()[0];
                q.poll();
                for (int i = 0; i < 6; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    int nz = z + dz[i];
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c || nz < 0 || nz >= l) continue;
                    if (dist[nz][nx][ny] > 0 || map[nz][nx][ny] == '#') continue;
                    dist[nz][nx][ny] = dist[z][x][y] + 1;
                    q.add(new Integer[] {nz, nx, ny});
                }
            }
            if (dist[goal[0]][goal[1]][goal[2]] != 0)
                System.out.println("Escaped in " + dist[goal[0]][goal[1]][goal[2]] + " minute(s).");
            else System.out.println("Trapped!");
        }
    }
}