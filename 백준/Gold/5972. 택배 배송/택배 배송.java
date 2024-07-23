import java.util.*;
import java.io.*;

public class Main {
    static List<List<int[]>> g = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
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
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 1000000000);
        dist[1] = 0;
        pq.add(new int[] {1, 0});
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
        System.out.print(dist[n]);
    }
}