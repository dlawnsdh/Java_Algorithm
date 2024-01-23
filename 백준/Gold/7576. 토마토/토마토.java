import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int m = sc.nextInt();
        int[][] box = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        int zero = 0;
        LinkedList<int[]> l = new LinkedList<>();
        for (int i = 0; i < m; i++)
            for (int k = 0; k < n; k++) {
                box[i][k] = sc.nextInt();
                if (box[i][k] == 1)
                    l.add(new int[] {i, k});
                else if (box[i][k] == 0) zero++;
            }
        
        while (!l.isEmpty()) {
            int[] xy = l.pop();
            visited[xy[0]][xy[1]] = true;
            for (int j = 0; j < 4; j++) {
                int nx = dx[j] + xy[0];
                int ny = dy[j] + xy[1];
                if (nx >= m || nx < 0 || ny >= n || ny < 0)
                    continue;
                if (visited[nx][ny] || box[nx][ny] != 0)
                    continue;
                visited[nx][ny] = true;
                l.add(new int[] {nx, ny});
                box[nx][ny] = box[xy[0]][xy[1]] + 1;
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < m; i++)
            for (int k = 0; k < n; k++) {
                if (box[i][k] == 0) {
                    System.out.print(-1);
                    return;
                }
                cnt = Math.max(cnt, box[i][k]);
            }
        if (zero == 0) System.out.print(0); 
        else System.out.print(cnt - 1);
    }
}