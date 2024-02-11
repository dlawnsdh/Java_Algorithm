import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        List<List<Integer>> g = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            g.get(x).add(y);
            g.get(y).add(x);
        }
        
        LinkedList<Integer> q = new LinkedList<>();
        int[] dist = new int[n + 1];
        q.add(start);
        dist[start] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == end) {
                System.out.print(dist[end] - 1);
                return;
            }
            for (int i = 0; i < g.get(cur).size(); i++) {
                int y = g.get(cur).get(i);
                if (dist[y] > 0) continue;
                dist[y] = dist[cur] + 1;
                q.add(y);
            }
        }    
        System.out.print(-1);
    }
}