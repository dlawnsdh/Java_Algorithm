import java.util.*;
import java.io.*;

public class Main {
    static int[] dijkstra(List<List<int[]>> g, int st) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[g.size()];
        Arrays.fill(dist, 1000000000);
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
        return dist;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        while (t --> 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            List<List<int[]>> g = new ArrayList<>();
            for (int i = 0; i <= n; i++)
                g.add(new ArrayList<>());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                g.get(a).add(new int[] {b, c});
                g.get(b).add(new int[] {a, c});
            }
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[k];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            
            int[][] total = new int[n + 1][2];
            for (int i = 1; i <= n; i++)
                total[i][0] = i;
            for (int i = 0; i < k; i++) {
                int[] dist = dijkstra(g, arr[i]);
                for (int j = 1; j <= n; j++)
                    total[j][1] += dist[j];
            }
            Arrays.sort(total, (a, b) -> a[1] - b[1]);
            System.out.println(total[1][0]);
        }
    }
}