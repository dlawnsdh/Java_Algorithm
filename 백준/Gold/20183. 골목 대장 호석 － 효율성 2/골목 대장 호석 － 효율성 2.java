import java.util.*;
import java.io.*;

public class Main {
    static List<List<Node>> g = new ArrayList<>();
    
    static class Node implements Comparable<Node> {
        int next;
        int cost;
        long rest;
        
        Node(int n, int c, long r) {
            this.next = n;
            this.cost = c;
            this.rest = r;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    } 
    
    static int dijkstra(int st, int en, long c) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[g.size()];
        Arrays.fill(dist, -1);
        
        int max = 0;
        dist[st] = 0;
        pq.add(new Node(st, 0, c));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.next == en)
                return max;
            for (int i = 0; i < g.get(cur.next).size(); i++) {
                Node nx = g.get(cur.next).get(i);
                if (dist[nx.next] < 0 && dist[nx.next] < nx.cost && cur.rest - nx.cost >= 0) {
                    max = Math.max(max, nx.cost);
                    dist[nx.next] = nx.cost;
                    pq.add(new Node(nx.next, dist[nx.next], cur.rest - nx.cost));
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            g.get(x).add(new Node(y, z, 0));
            g.get(y).add(new Node(x, z, 0));
        }
        
        System.out.print(dijkstra(a, b, c));
    }
}