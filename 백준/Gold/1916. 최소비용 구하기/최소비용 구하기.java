import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g.get(u).add(new int[] {v, w});
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        q.add(new int[] {start, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;
            for (int i = 0; i < g.get(cur[0]).size(); i++) {
                int[] nx = g.get(cur[0]).get(i);
                if (dist[nx[0]] > dist[cur[0]] + nx[1]) {
                    dist[nx[0]] = dist[cur[0]] + nx[1];
                    q.add(new int[] {nx[0], dist[nx[0]]});
                }
            }
        }
        System.out.print(dist[end]);
    }
}