import java.util.*;
import java.io.*;

public class Main {
    static List<int[]> coordinates = new ArrayList<>();
    static int[][] map;
    static boolean[] visited;
    static int max = 0;
    
    static void dfs(int d, int st) {
        if (d == 3) {
            int cnt = 0;
            int[][] arr = new int[map.length][map[0].length];
            for (int i = 0; i < arr.length; i++)
                System.arraycopy(map[i], 0, arr[i], 0, arr[0].length);
            for (int i = 0; i < coordinates.size() && cnt < 3; i++)
                if (visited[i]) {
                    int[] wall = coordinates.get(i);
                    arr[wall[0]][wall[1]] = 1;
                    cnt++;
                }
            max = Math.max(max, bfs(arr));
            return;
        }
        
        for (int i = st; i < coordinates.size(); i++) {
            visited[i] = true;
            dfs(d + 1, i + 1);
            visited[i] = false;
        }
    }
    
    static int bfs(int[][] map) {
        boolean[][] check = new boolean[map.length][map[0].length];
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for (int i = 0; i < map.length; i++)
            for (int k = 0; k < map[0].length; k++)
                if (!check[i][k] && map[i][k] == 2) {
                    q.add(new int[] {i, k});
                    check[i][k] = true;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int j = 0; j < 4; j++) {
                            int nx = cur[0] + dx[j];
                            int ny = cur[1] + dy[j];
                            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                            if (check[nx][ny] || map[nx][ny] == 1) continue;
                            check[nx][ny] = true;
                            map[nx][ny] = 2;
                            q.add(new int[] {nx, ny});
                        }
                    }
                }
        int safe = 0;
        for (int i = 0; i < map.length; i++)
            for (int k = 0; k < map[0].length; k++)
                if (map[i][k] == 0) 
                    safe++;
        return safe;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < m; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
                if (map[i][k] == 0)
                    coordinates.add(new int[] {i, k});
            }
        }
        visited = new boolean[coordinates.size()];
        
        dfs(0, 0);
        System.out.print(max);
    }
}