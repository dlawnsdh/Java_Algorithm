import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue<int[]> q = new LinkedList<>();
        String[] str = sc.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] map = new int[n][m];
        int[][] dist = new int[n][m];
        boolean[][][] visited = new boolean[2][n][m];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int k = 0; k < m; k++)
                map[i][k] = s.charAt(k) - 48;
        }

        if(n - 1 == 0 && m - 1 == 0){
            System.out.print(1);
            return;
        }  
      
        q.add(new int[] {0, 0, 0});
        while (!q.isEmpty()) {
            int[] cur =  q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (map[nx][ny] == 1) {
                    if (cur[2] == 0 && !visited[1][nx][ny]) {
                        visited[cur[2]][nx][ny] = true;
                        q.add(new int[] {nx, ny, 1});
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                    }
                }
                else {
                    if (!visited[cur[2]][nx][ny]) {
                        visited[cur[2]][nx][ny] = true;
                        q.add(new int[] {nx, ny, cur[2]});
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                    }
                }
                if (nx == n - 1 && ny == m - 1) {
                    System.out.print(dist[n - 1][m - 1] + 1);
                    return;
                }
            }
        }
        System.out.print(-1);
    }
}