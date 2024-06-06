import java.util.*;
import java.io.*;

public class Main {
    static List<List<Node>> g = new ArrayList<>();
    
    static class Node {
        int next;
        long cost;
        
        Node(int n, long c) {
            this.next = n;
            this.cost = c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] map = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long t = Long.parseLong(st.nextToken());
            g.get(a).add(new Node(b, t));
            g.get(b).add(new Node(a, t));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        boolean[] visited = new boolean[n];
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        pq.add(new Node(0,0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.next]) continue;
            visited[cur.next] = true;
            for (int i = 0; i < g.get(cur.next).size(); i++) {
                Node nx = g.get(cur.next).get(i);
                if (nx.next != n - 1 && map[nx.next] == 1) continue;
                if (dist[nx.next] > dist[cur.next] + nx.cost) {
                    dist[nx.next] = dist[cur.next] + nx.cost;
                    pq.add(new Node(nx.next, dist[nx.next]));
                }
            }
        }
        if (dist[n - 1] == Long.MAX_VALUE)
            dist[n - 1] = -1;
        System.out.print(dist[n - 1]);
    }
}