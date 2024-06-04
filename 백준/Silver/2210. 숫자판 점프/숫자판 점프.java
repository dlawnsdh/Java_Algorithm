import java.util.*;
import java.io.*;

public class Main {
    static Set<String> set = new HashSet<>();
    static int[][] map = new int[5][5];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static void dfs(int[] result, int d, int x, int y) {
        if (d == 6) {
            StringBuilder b = new StringBuilder();
            for (int i : result)
                b.append(i);
            set.add(b.toString());
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > 4 || ny < 0 || ny > 4) continue;
            result[d] = map[nx][ny];
            dfs(result, d + 1, nx, ny);
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++)
            for (int k = 0; k < 5; k++)
                map[i][k] = sc.nextInt();
        
        for (int i = 0; i < 5; i++)
            for (int k = 0; k < 5; k++)
                dfs(new int[6], 0, i, k);
        System.out.print(set.size());
    }
}