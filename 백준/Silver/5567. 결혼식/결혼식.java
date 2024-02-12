import java.util.*;
import java.io.*;

public class Main {
    public static List<List<Integer>> g = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            g.get(x).add(y);
            g.get(y).add(x);
        }
        
        int[] dist = new int[n + 1];
        LinkedList<Integer> q = new LinkedList<>();
        Arrays.fill(dist, -1);
        int cnt = 0;
        q.add(1);
        dist[1] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < g.get(cur).size(); i++) {
                int x = g.get(cur).get(i);
                if (dist[x] >= 0) continue;
                dist[x] = dist[cur] + 1;
                q.add(x);
                if (dist[x] > 2) {
                    System.out.print(cnt);
                    return;
                } else cnt++;
            }
        }
        System.out.print(cnt);
    }
}