import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        List<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            g[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        q.add(x);
        dist[x] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < g[cur].size(); i++) {
                int nx = g[cur].get(i);
                if (dist[nx] == -1) {
                    dist[nx] = dist[cur] + 1;
                    q.add(nx);
                }
            }
        }
        
        for (int i = 1; i <= n; i++)
            if (dist[i] == k) 
                sb.append(i).append('\n');
        if (sb.length() == 0) System.out.print(-1);
        else System.out.print(sb);
    }
}