import java.util.*;
import java.io.*;

public class Main {
    static List<List<Node>> g = new ArrayList<>();
    
    static class Node implements Comparable<Node> {
        int next;
        long cost;
        
        Node(int n, long c) {
            this.next = n;
            this.cost = c;
        }
        
        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    } 
    
    static long dijkstra(int st, int en, int cost) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long[] dist = new long[g.size()];
        Arrays.fill(dist, Long.MAX_VALUE);
        
        dist[st] = 0;
        pq.add(new Node(st, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.next] < cur.cost)
                continue;
            for (int i = 0; i < g.get(cur.next).size(); i++) {
                Node nx = g.get(cur.next).get(i);
                if (nx.cost > cost)
                    continue;
                if (dist[nx.next] > dist[cur.next] + nx.cost) {
                    dist[nx.next] = dist[cur.next] + nx.cost;
                    pq.add(new Node(nx.next, dist[nx.next]));
                }
            }
        }
        return dist[en];
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
            long z = Long.parseLong(st.nextToken());
            g.get(x).add(new Node(y, z));
            g.get(y).add(new Node(x, z));
        }
        
        // 문제에 최대중에 최소 또는 최소중에 최대를 구하면서 범위가 크다면 매개변수 탐색일 확률이 큼
        // 수금액을 매개변수 탐색으로 찾고 mid값으로 다익스트라를 실행한다.
        // 지정한 mid(요금)보타 실제 요금이 큰 경우는 return 값이 Long.MAX_VALUE 이기때문에 
        // 최대 요금인 c 보다 무조건 크므로 mid 값을 증가시켜서 요금을 낼 수 있게 해야함
        // 그렇기 때문에 요금의 총합이 c 보다 큰 경우에 mid 를 증가시키고 
        // 아닌경우에 mid 값을 감소시켜 최대중에 최소를 찾을 수 있게끔 한다.
        int start = 1;
        int end = 1000000000;
        int max = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (dijkstra(a, b, mid) > c)
                start = mid + 1;
            else {
                end = mid - 1;
                max = mid;
            }
        }
        System.out.print(max);
    }
}