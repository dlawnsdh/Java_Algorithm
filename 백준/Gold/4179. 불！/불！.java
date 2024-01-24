import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int r = Integer.parseInt(arr[0]);
        int c = Integer.parseInt(arr[1]);
        char[][] map = new char[r][c];
        LinkedList<int[]> jihun = new LinkedList<>();
        LinkedList<int[]> fire = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[][] result1 = new int[r][c];
        int[][] result2 = new int[r][c];
        
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int k = 0; k < c; k++) {
                result1[i][k] = -1;
                result2[i][k] = -1;
                map[i][k] = s.charAt(k);
                if (s.charAt(k) == 'F') {
                    fire.add(new int[] {i, k});
                    result1[i][k] = 0;
                }
                if (s.charAt(k) == 'J') {
                    jihun.add(new int[] {i, k});
                    result2[i][k] = 0;    
                }
            }
        }

        while (!fire.isEmpty()) {
            int[] xy = fire.poll();
            for (int i = 0; i < 4; i++) {
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];
                if (nx < 0 | nx >= r || ny < 0 || ny >= c)
                    continue;
                if (result1[nx][ny] >= 0 || map[nx][ny] == '#')
                    continue;
                result1[nx][ny] = result1[xy[0]][xy[1]] + 1;
                fire.add(new int[] {nx, ny});
            }
        }
        
        while (!jihun.isEmpty()) {
            int[] xy = jihun.poll();
            for (int i = 0; i < 4; i++) {
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];
                if (nx < 0 | nx >= r || ny < 0 || ny >= c) {
                    System.out.println(result2[xy[0]][xy[1]] + 1);
                    return;
                }
                if (result2[nx][ny] >= 0 || map[nx][ny] == '#')
                    continue;
                if (result1[nx][ny] != -1 && result1[nx][ny] <= result2[xy[0]][xy[1]] + 1)
                    continue;
                result2[nx][ny] = result2[xy[0]][xy[1]] + 1;
                jihun.add(new int[] {nx, ny});
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}