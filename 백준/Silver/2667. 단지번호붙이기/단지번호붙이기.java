import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int k = 0; k < n; k++)
                map[i][k] = s.charAt(k) - 48;
        }
        
        int cnt = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        LinkedList<int[]> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            for (int k = 0; k < n; k++) 
                if (!visited[i][k] && map[i][k] == 1) {
                    cnt++;
                    visited[i][k] = true;
                    q.add(new int[] {i, k});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int j = 0; j < 4; j++) {
                            int nx = cur[0] + dx[j];
                            int ny = cur[1] + dy[j];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if (visited[nx][ny] || map[nx][ny] == 0) continue;
                            visited[nx][ny] = true;
                            map[i][k]++;
                            q.add(new int[] {nx, ny});
                        }
                    }
                    l.add(map[i][k]);
                }
        Collections.sort(l);
        System.out.println(cnt);
        l.forEach(System.out::println);
    }
}