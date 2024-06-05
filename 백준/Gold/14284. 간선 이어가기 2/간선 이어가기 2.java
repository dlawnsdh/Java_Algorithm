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
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        pq.add(new int[] {s, 0});
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) 
                continue;
            visited[cur[0]] = true;
            
            for (int i = 0; i < g.get(cur[0]).size(); i++) {
                int[] nx = g.get(cur[0]).get(i);
                if (dist[nx[0]] > dist[cur[0]] + nx[1]) {
                    dist[nx[0]] = dist[cur[0]] + nx[1];
                    pq.add(new int[] {nx[0], dist[nx[0]]});
                }
            }
        }
        System.out.print(dist[t]);
    }
}