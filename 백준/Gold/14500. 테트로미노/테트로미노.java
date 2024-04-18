import java.util.*;
import java.io.*;

public class Main {
    static int max = 0;
    static int[][] arr;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < m; k++)
                arr[i][k] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++)
            for (int k = 0; k < m; k++) {
                visited[i][k] = true;
                dfs(i, k, 0, 0);
                visited[i][k] = false;
            }
        System.out.print(max);
    }
    
    static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }
            
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length) continue;
            if (!visited[nx][ny]) {
                if (cnt == 2) { // ㅗ 모양 블록을 탐색
                    visited[nx][ny] = true;
                    dfs(x, y, cnt + 1, sum + arr[nx][ny]);
                    visited[nx][ny] = false;
                }
                
                visited[nx][ny] = true;
                dfs(nx, ny, cnt + 1, sum + arr[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }
}