import java.util.*;
import java.io.*;

public class Main {
    static List<List<int[]>> g = new ArrayList<>();
    
    static int dijkstra(int st, int en, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[g.size()];
        Arrays.fill(dist, -1);

        dist[st] = 0;
        pq.add(new int[] {st, 0, c});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == en)
                return dist[en];
            for (int i = 0; i < g.get(cur[0]).size(); i++) {
                int[] nx = g.get(cur[0]).get(i);
                if (cur[2] - nx[1] < 0 || dist[nx[0]] >= 0) 
                    continue;
                dist[nx[0]] = Math.max(dist[cur[0]], nx[1]);
                pq.add(new int[] {nx[0], dist[nx[0]], cur[2] - nx[1]});
            }
        }
        return -1;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            g.get(x).add(new int[] {y, z});
            g.get(y).add(new int[] {x, z});
        }
        
        System.out.print(dijkstra(a, b, c));
    }
}