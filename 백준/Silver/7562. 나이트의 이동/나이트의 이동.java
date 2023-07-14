import java.util.*;

public class Main {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int t = sc.nextInt();
         int[][] d = {{-2, -1}, {-1, -2}, {2, -1}, {1, -2}, 
                      {-2, 1}, {-1, 2}, {2, 1}, {1, 2}};
         
         for (int k = 0; k < t; k++) {
             Queue<Integer[]> q = new LinkedList<>();
             int n = sc.nextInt();
             int sx = sc.nextInt(); int sy = sc.nextInt();
             int gx = sc.nextInt(); int gy = sc.nextInt();
             int[][] dist = new int[n][n];
             
             if (sx == gx && sy == gy) {
                System.out.println(0);
                continue;
            }
             
             q.add(new Integer[] {sx, sy});
             while (!q.isEmpty()) {
                 int x = q.peek()[0];
                 int y = q.peek()[1];
                 q.poll();
                 for (int i = 0; i < 8; i++) {
                     int nx = x + d[i][0];
                     int ny = y + d[i][1];
                     if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                     if (dist[nx][ny] > 0) continue;
                     dist[nx][ny] = dist[x][y] + 1;
                     q.add(new Integer[] {nx, ny});
                     if (nx == gx && ny == gy) {
                         System.out.println(dist[nx][ny]);
                         break;
                     }
                 }
             }
         }
     }
}