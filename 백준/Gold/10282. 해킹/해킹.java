import java.util.*;
import java.io.*;

public class Main {
    static int INF = 1000000000;
    
    static int[] dijkstra(List<List<int[]>> g, int st) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[g.size()];
        Arrays.fill(dist, INF);
        dist[st] = 0;
        pq.add(new int[] {st, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int i = 0; i < g.get(cur[0]).size(); i++) {
                int[] nx = g.get(cur[0]).get(i);
                if (dist[nx[0]] > dist[cur[0]] + nx[1]) {
                    dist[nx[0]] = dist[cur[0]] + nx[1];
                    pq.add(new int[] {nx[0], dist[nx[0]]});
                }
            }
        }
        
        int max = 0;
        int cnt = 0;
        for (int i = 1; i < g.size(); i++)
            if (dist[i] != INF) {
                cnt++;
                if (dist[i] > max)
                    max = dist[i];
            }
        return new int[] {cnt, max};
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        while (t --> 0) {
            List<List<int[]>> g = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for (int i = 0; i <= n; i++)
                g.add(new ArrayList<>());
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                g.get(b).add(new int[] {a, s});
            }
            
            int[] result = dijkstra(g, c);
            sb.append(result[0]).append(' ').append(result[1]).append('\n');
        }
        System.out.print(sb);
    }
}