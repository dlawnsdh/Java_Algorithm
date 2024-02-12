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
        
        boolean[] visited = new boolean[n + 1];
        LinkedList<Integer> q = new LinkedList<>();
        int cnt = 0;
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < g.get(cur).size(); i++) {
                int x = g.get(cur).get(i);
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                    cnt++;
                } 
            }
        }
        System.out.print(cnt);
    }
}