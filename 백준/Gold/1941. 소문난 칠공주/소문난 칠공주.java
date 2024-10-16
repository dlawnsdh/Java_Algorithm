import java.util.*;
import java.io.*;

public class Main {
    static char[][] map = new char[5][5];
    static int[][] point = new int[25][2];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int sum = 0;

    static boolean bfs(int[] arr) {
        char[][] m = new char[5][5];
        for (int i = 0; i < 5; i++)
            Arrays.fill(m[i], '.');
        for (int i = 0; i < 7; i++)
            m[point[arr[i]][0]][point[arr[i]][1]] = map[point[arr[i]][0]][point[arr[i]][1]];

        boolean[][] visited = new boolean[5][5];
        int count = 0;
        for (int i = 0; i < 5; i++)
            for (int k = 0; k < 5; k++)
                if (!visited[i][k] && m[i][k] != '.') {
                    count++;
                    visited[i][k] = true;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, k});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int j = 0; j < 4; j++) {
                            int nx = cur[0] + dx[j];
                            int ny = cur[1] + dy[j];
                            if (nx < 0 || nx > 4 || ny < 0 || ny > 4) continue;
                            if (visited[nx][ny] || m[nx][ny] == '.') continue;
                            visited[nx][ny] = true;
                            q.add(new int[] {nx, ny});
                        }
                    }
                }
        return count == 1;
    }

    static void dfs(int[] arr, int y, int d, int st) {
        if (y > 3) return;
        if (d == 7) {
            if (bfs(arr))
                sum++;
        } else {
            for (int i = st; i < 25; i++) {
                arr[d] = i;
                if (map[point[i][0]][point[i][1]] == 'Y')
                    dfs(arr, y + 1, d + 1, i + 1);
                else dfs(arr, y, d + 1, i + 1);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++)
            map[i] = br.readLine().toCharArray();
        int idx = 0;
        for (int i = 0; i < 5; i++)
            for (int k = 0; k < 5; k++)
                point[idx++] = new int[] {i, k};
        
        dfs(new int[7], 0, 0, 0);
        System.out.print(sum);
    }
}
