import java.util.*;
import java.io.*;

public class Main {
    static int[] dist = new int[100000];
    
    static boolean bfs(int n, int t, int g) {
        Queue<int[]> q = new LinkedList<>();
        Arrays.fill(dist, -1);
        q.add(new int[] {n, 0});
        dist[n] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[1] > t) return false;
            if (cur[0] == g) return true;
            
            int nx = cur[0] + 1;
            if (nx < 100000 && dist[nx] < 0) {
                dist[nx] = dist[cur[0]] + 1;
                q.add(new int[] {nx, cur[1] + 1});
            }
            nx = cur[0] * 2;
            if (nx != 0 && nx < 100000) {
                nx -= (int) Math.pow(10, String.valueOf(nx).length() - 1);
                if (dist[nx] >= 0) continue;
                dist[nx] = dist[cur[0]] + 1;
                q.add(new int[] {nx, cur[1] + 1});
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        
        if (bfs(n, t, g)) System.out.print(dist[g]);
        else System.out.print("ANG");
    }
}