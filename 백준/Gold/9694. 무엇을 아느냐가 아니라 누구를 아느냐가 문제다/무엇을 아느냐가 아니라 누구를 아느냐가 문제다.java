import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int k = 1; k <= t; k++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            List<List<int[]>> g = new ArrayList<>();
            for (int i = 0; i < m; i++)
                g.add(new ArrayList<>());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                g.get(x).add(new int[] {y, z});
                g.get(y).add(new int[] {x, z});
            }
            
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            int[] dist = new int[m];
            int[] route = new int[m];
            boolean[] visited = new boolean[m];
            Arrays.fill(dist, Integer.MAX_VALUE);
            Arrays.fill(route, -1);
            dist[0] = 0;
            pq.add(new int[] {0, 0});
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                if (visited[cur[0]]) continue;
                visited[cur[0]] = true;
                for (int i = 0; i < g.get(cur[0]).size(); i++) {
                    int[] nx = g.get(cur[0]).get(i);
                    if (dist[nx[0]] > dist[cur[0]] + nx[1]) {
                        route[nx[0]] = cur[0];
                        dist[nx[0]] = dist[cur[0]] + nx[1];
                        pq.add(new int[] {nx[0], dist[nx[0]]});
                    }
                }
            }
            if (dist[m - 1] == Integer.MAX_VALUE) System.out.printf("Case #%d: -1\n", k);
		    else {
			    Stack<Integer> stack = new Stack<>();
			    for (int i = m - 1; i > 0;)
				    stack.push(i = route[i]);
			    System.out.printf("Case #%d:", k);
			    while(!stack.empty()) {
				    System.out.printf(" %d",stack.pop());
			    }
			    System.out.printf(" %d\n", m - 1);
		    }
        }
    }
}