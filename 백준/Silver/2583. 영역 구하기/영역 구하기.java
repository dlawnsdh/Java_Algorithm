import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int[] l = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] r = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            for (int j = l[1]; j < r[1]; j++)
                for (int h = l[0]; h < r[0]; h++)
                    map[j][h] = 1;
        }
        
        int cnt = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        LinkedList<int[]> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    cnt++;
                    visited[i][j] = true;
                    q.add(new int[] {i, j});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int h = 0; h < 4; h++) {
                            int nx = cur[0] + dx[h];
                            int ny = cur[1] + dy[h];
                            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                            if (visited[nx][ny] || map[nx][ny] == 1) continue;
                            visited[nx][ny] = true;
                            map[i][j]++;
                            q.add(new int[] {nx, ny});
                        }
                    }
                    l.add(map[i][j] + 1);
                }
            }
        Collections.sort(l);
        System.out.println(cnt);
        l.forEach(i -> System.out.print(i + " "));
    }
}