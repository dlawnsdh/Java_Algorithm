import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] map = new int[101];
        int[] dist = new int[101];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x] = y;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u] = v;
        }
        
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist, -1);
        q.add(1);
        dist[1] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == 100) break;
            for (int dice = 1; dice <= 6; dice++) {
                int nx = cur + dice;
                if (nx > 100 || dist[nx] >= 0 || dist[map[nx]] >= 0) continue;
                if (map[nx] > 0) {
                    dist[map[nx]] = dist[cur] + 1;
                    q.add(map[nx]);
                } else {
                    dist[nx] = dist[cur] + 1;
                    q.add(nx);
                }
            }
        }
        System.out.print(dist[100]);
    }
}