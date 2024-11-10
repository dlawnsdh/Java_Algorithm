import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n, m;
    static Map<Character, int[]> op = new HashMap<>() {{
        put('U', new int[] {-1, 0});
        put('D', new int[] {1, 0});
        put('L', new int[] {0, -1});
        put('R', new int[] {0, 1});
    }};
    
    static void bfs(int x, int y, char c) {
        Queue<int[]> q = new LinkedList<>();
        
        visited[x][y] = true;
        q.add(new int[] {x, y});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            arr[cur[0]][cur[1]] = '.';
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (!visited[nx][ny] && map[nx][ny] == c) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        arr = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int k = 0; k < m; k++) {
                map[i][k] = s.charAt(k);
                arr[i][k] = '#';
            }
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        
        String route = br.readLine();
        for (int i = 0; i < route.length(); i++) {
            if (route.charAt(i) == 'W') {
                bfs(x, y, map[x][y]);
            } else {
                int[] d = op.get(route.charAt(i));
                x += d[0];
                y += d[1];
            }
        }
        
        arr[x][y] = '.';
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            arr[nx][ny] = '.';
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(arr[i]).append('\n');
        System.out.print(sb);
    }
}