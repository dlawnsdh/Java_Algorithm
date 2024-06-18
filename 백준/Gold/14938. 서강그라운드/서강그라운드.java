import java.util.*;
import java.io.*;

public class Main {
    static List<List<int[]>> g = new ArrayList<>();
    static int[] arr;
    static int INF = 100000000;
    
    static int dijkstra(int st, int m) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[g.size()];
        boolean[] visited = new boolean[g.size()];
        Arrays.fill(dist, INF);
        
        dist[st] = 0;
        pq.add(new int[] {st, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;
            for (int i = 0; i < g.get(cur[0]).size(); i++) {
                int[] nx = g.get(cur[0]).get(i);
                if (dist[nx[0]] > dist[cur[0]] + nx[1]) {
                    dist[nx[0]] = dist[cur[0]] + nx[1];
                    pq.add(new int[] {nx[0], dist[nx[0]]});
                }
            }
        }
        int sum = 0;
        for (int i = 1; i < dist.length; i++)
            if (dist[i] <= m)
                sum += arr[i];
        return sum;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g.get(a).add(new int[] {b, c});
            g.get(b).add(new int[] {a, c});
        }
        
        int max = 0;
        for (int i = 1; i <= n; i++) 
            max = Math.max(max, dijkstra(i, m));
        System.out.print(max);
    }
}