import java.util.*;
import java.io.*;

class Node {
    int next;
    int cost;
    
    public Node(int n, int c) {
        this.next = n;
        this.cost = c;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(t.nextToken());
        int m = Integer.parseInt(t.nextToken());
        int x = Integer.parseInt(t.nextToken());
        
        ArrayList<ArrayList<Node>> g1 = new ArrayList<>();
        ArrayList<ArrayList<Node>> g2 = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g1.add(new ArrayList<>());
            g2.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            t = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(t.nextToken());
            int v = Integer.parseInt(t.nextToken());
            int w = Integer.parseInt(t.nextToken());
            g1.get(u).add(new Node(v, w));
            g2.get(v).add(new Node(u, w));
        } 
        
        int[] dist1 = func(g1, x, n);
        int[] dist2 = func(g2, x, n);
        int max = 0;
        for (int i = 1; i <= n; i++)
            max = Math.max(max, dist1[i] + dist2[i]);
        System.out.print(max);
    }
        
    public static int[] func(ArrayList<ArrayList<Node>> g, int x, int n) {   
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;
        q.add(new Node(x, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (visited[cur.next]) continue;
            visited[cur.next] = true;
            for (int i = 0; i < g.get(cur.next).size(); i++) {
                Node nx = g.get(cur.next).get(i);
                if (dist[nx.next] > cur.cost + nx.cost) {
                    dist[nx.next] = cur.cost + nx.cost;
                    q.add(new Node(nx.next, dist[nx.next]));
                }
            }
        }
        return dist;
    }
}