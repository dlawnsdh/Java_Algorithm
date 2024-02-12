import java.util.*;
import java.io.*;

public class Main {
    public static List<List<Integer>> g = new ArrayList<>();
    
    public static void dfs(int x, boolean[] visited) {
        System.out.print(x + " ");
        visited[x] = true;
        for (int i = 0; i < g.get(x).size(); i++) {
            int y = g.get(x).get(i);
            if (!visited[y])
                dfs(y, visited);
        }
    }
    
    public static void bfs(int start, boolean[] visited) {
        LinkedList<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");
            for (int i = 0; i < g.get(cur).size(); i++) {
                int x = g.get(cur).get(i);
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            g.get(x).add(y);
            g.get(y).add(x);
        }
        for (int i = 1; i <= n; i++)
            Collections.sort(g.get(i));
        
        dfs(start, new boolean[1001]);
        System.out.println();
        bfs(start, new boolean[1001]);
    }
}