import java.util.*;
import java.io.*;

public class Main {
    static List<List<int[]>> g = new ArrayList<>();
    static int[] dist, route;
    
    static void dijkstra(int st) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        dist[st] = 0;
        pq.add(new int[] {st, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (dist[cur[0]] < cur[1])
                continue;
            for (int i = 0; i < g.get(cur[0]).size(); i++) {
                int[] nx = g.get(cur[0]).get(i);
                if (dist[nx[0]] > dist[cur[0]] + nx[1]) {
                    dist[nx[0]] = dist[cur[0]] + nx[1];
                    pq.add(new int[] {nx[0], dist[nx[0]]});
                    route[nx[0]] = cur[0];
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        route = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        StringTokenizer st;
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g.get(a).add(new int[] {b, c});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        dijkstra(start);

        System.out.println(dist[end]);
        Stack<Integer> stack = new Stack<>();
		stack.push(end);
        int cnt = 0;
		while (route[end] != 0) {
			cnt++;
			stack.push(route[end]);
			end = route[end];
		}
		System.out.println(cnt + 1);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
    }
}