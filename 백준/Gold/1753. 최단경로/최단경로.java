import java.util.*;
import java.io.*;

class Node {
    int n;
    int w;
    
    public Node(int n, int w) {
        this.n = n;
        this.w = w;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        
        List<List<Node>> g = new ArrayList<>();
        int[] dist = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            g.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g.get(u).add(new Node(v, w));
        }
        
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.w - b.w);
        boolean[] visited = new boolean[V + 1];
        dist[start] = 0;
        q.add(new Node(start, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (visited[cur.n]) continue;
            visited[cur.n] = true;
            for (int i = 0; i < g.get(cur.n).size(); i++) {
                Node x = g.get(cur.n).get(i);
                if (dist[x.n] > cur.w + x.w) {
                    dist[x.n] = cur.w + x.w;
                    q.add(new Node(x.n, dist[x.n]));
                }
            }
        }
        
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}