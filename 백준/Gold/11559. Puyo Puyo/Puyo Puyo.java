import java.util.*;
import java.io.*;

public class Main {
    static char[][] map = new char[12][6];
    
    static boolean bfs() {
        boolean isRemoved = false;
        boolean[][] visited = new boolean[12][6];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for (int i = 0; i < 12; i++)
            for (int k = 0; k < 6; k++)
                if (!visited[i][k] && map[i][k] != '.') {
                    List<int[]> remove = new ArrayList<>();
                    Queue<int[]> q = new LinkedList<>();
                    
                    remove.add(new int[] {i, k});
                    visited[i][k] = true;
                    q.add(new int[] {i, k, map[i][k]});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int j = 0; j < 4; j++) {
                            int nx = cur[0] + dx[j];
                            int ny = cur[1] + dy[j];
                            if (nx < 0 || nx > 11 || ny < 0 || ny > 5) continue;
                            if (!visited[nx][ny] && map[nx][ny] == map[i][k]) {
                                visited[nx][ny] = true;
                                remove.add(new int[] {nx, ny});
                                q.add(new int[] {nx, ny, map[i][k]});
                            }
                        }
                    }
                    
                    if (remove.size() >= 4) {
                        isRemoved = true;
                        for (int[] xy : remove)
                            map[xy[0]][xy[1]] = '.';
                    }
                }
        return isRemoved;
    }
    
    static void moveNode() {
        for (int i = 0; i < 6; i++) {
            StringBuilder sb = new StringBuilder();
            for (int k = 11; k >= 0; k--)
                if (map[k][i] != '.')
                    sb.append(map[k][i]);
            sb.append(".".repeat(12 - sb.length()));
            sb.reverse();
            for (int k = 0; k < 12; k++)
                map[k][i] = sb.charAt(k);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++)
            map[i] = br.readLine().toCharArray();
        
        int total = 0;
        while (true) {
            if (!bfs()) 
                break;
            moveNode();
            total++;
        }
        System.out.print(total);
    }
}