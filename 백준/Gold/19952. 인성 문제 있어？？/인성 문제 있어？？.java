import java.util.*;
import java.io.*;

public class Main {
    static boolean bfs(int[][] map, int h, int w, int f, int[] start, int[] end) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[h + 1][w + 1];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        visited[start[0]][start[1]] = true;
        q.add(new int[] {start[0], start[1], f});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == end[0] && cur[1] == end[1] && cur[2] >= 0)
                return true;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 1 || nx > h || ny < 1 || ny > w) continue;
                if (visited[nx][ny] || cur[2] < map[nx][ny] - map[cur[0]][cur[1]]) continue;
                visited[nx][ny] = true;
                q.add(new int[] {nx, ny, cur[2] - 1}); 
            }
        } 
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (t --> 0) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[][] map = new int[h + 1][w + 1];
            for (int i = 0; i < o; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                map[x][y] = l;
            }
            
            if (bfs(map, h, w, f, start, end))
                sb.append("잘했어!!").append('\n');
            else sb.append("인성 문제있어??").append('\n');
        }
        System.out.print(sb);
    }
}