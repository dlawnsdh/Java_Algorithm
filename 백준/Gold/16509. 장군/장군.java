import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int[][] dist = new int[10][9];
        for (int i = 0; i < 10; i++)
            Arrays.fill(dist[i], -1);
        
        int[][] dx = {{-1, -1, -1}, {-1, -1, -1}, {0, -1, -1}, {0, 1, 1}, {1, 1, 1}, {1, 1, 1}, {0, 1, 1}, {0, -1, -1}};
        int[][] dy = {{0, -1, -1}, {0, 1, 1}, {1, 1, 1}, {1, 1, 1}, {0, 1, 1}, {0, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[] {r1, c1});
        dist[r1][c1] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == r2 && cur[1] == c2)
                break;
            for (int i = 0; i < 8; i++) {
                int nx = cur[0];
                int ny = cur[1];
                boolean flag = true;
                for (int k = 0; k < 3; k++) {
                    nx += dx[i][k];
                    ny += dy[i][k];
                    if (nx == r2 && ny == c2 && k < 2) {
                        flag = false;
                        break;
                    }
                }
                if (nx < 0 || nx > 9 || ny < 0 || ny > 8) continue;
                if (dist[nx][ny] >= 0) continue;
                if (flag) {
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                    q.add(new int[] {nx, ny});
                }
            }
        }
        System.out.print(dist[r2][c2]);
    }
}