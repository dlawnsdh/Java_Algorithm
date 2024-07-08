import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        List<int[]> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0)
                    l.add(new int[] {map[i][j], i, j, 0});
            }
        }
        Collections.sort(l, (a, b) -> a[0] - b[0]);
        Queue<int[]> q = new LinkedList<>(l);

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[3] == s) break;
            for (int j = 0; j < 4; j++) {
                int nx = cur[1] + dx[j];
                int ny = cur[2] + dy[j];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] > 0) continue;
                map[nx][ny] = cur[0];
                q.add(new int[]{cur[0], nx, ny, cur[3] + 1});

            }
        }
        System.out.print(map[x - 1][y - 1]);
    }
}