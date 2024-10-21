import java.util.*;
import java.io.*;

public class Main {
    static List<List<City>> g = new ArrayList<>();
    static int city;
    static long max = 0;
    
    static class City implements Comparable<City> {
        int next;
        long cost;
        
        City(int n, long c) {
            this.next = n;
            this.cost = c;
        }
        
        @Override
        public int compareTo(City o) {
            return (int) (this.cost - o.cost);
        }
    }
    
    static void dijkstra(int[] st) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        long[] dist = new long[g.size()];
        Arrays.fill(dist, Long.MAX_VALUE);
        for (int s : st) {
            pq.add(new City(s, 0));
            dist[s] = 0;
        }
        
        while (!pq.isEmpty()) {
            City cur = pq.poll();
            if (dist[cur.next] < cur.cost)
                continue;
            for (int i = 0; i < g.get(cur.next).size(); i++) {
                City nx = g.get(cur.next).get(i);
                if (dist[nx.next] > dist[cur.next] + nx.cost) {
                    dist[nx.next] = dist[cur.next] + nx.cost;
                    pq.add(new City(nx.next, dist[nx.next]));
                }
            }
        }
       
        for (int i = 1; i < dist.length; i++)
            if (dist[i] > max) {
                max = dist[i];
                city = i;
            }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            g.get(v).add(new City(u, c));
        }
        int[] arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        dijkstra(arr);
        System.out.print(city + "\n" + max);
    }
}