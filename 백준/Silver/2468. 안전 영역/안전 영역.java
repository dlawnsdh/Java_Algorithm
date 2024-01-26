import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    
        int[][] map = new int[n][n];
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int k = 0; k < n; k++) {
                map[i][k] = Integer.parseInt(str[k]);
                s.add(Integer.parseInt(str[k]));
            }
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
       
        List<Integer> l = new ArrayList<>();
        s.forEach(h -> {
            int sum = 0;
            LinkedList<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[n][n];
            for (int i = 0; i < n; i++)
                for (int k = 0; k < n; k++)
                    if (!visited[i][k] && map[i][k] > h) {
                        sum++;
                        visited[i][k] = true;
                        q.add(new int[] {i, k});
                        while (!q.isEmpty()) {
                            int cur[] = q.poll();
                            for (int j = 0; j < 4; j++) {
                                int nx = cur[0] + dx[j];
                                int ny = cur[1] + dy[j];
                                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                                if (visited[nx][ny] || map[nx][ny] <= h) continue;
                                visited[nx][ny] = true;
                                q.add(new int[] {nx, ny});
                            }
                        }
                        l.add(sum);
                    }
        });
        System.out.print(l.stream().max(Integer::compareTo).orElse(1));
    }
}