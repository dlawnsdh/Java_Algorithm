import java.util.*;
import java.io.*;

public class Main {
    public static List<List<Integer>> g = new ArrayList<>();
    public static boolean[] visited = new boolean[1001];
    
    public static void dfs(int x) {
        visited[x] = true;
        for (int i = 0; i < g.get(x).size(); i++) {
            int y = g.get(x).get(i);
            if (!visited[y])
                dfs(y);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            g.get(x).add(y);
            g.get(y).add(x);
        }
        
        int cnt = 0;
        for (int i = 1; i <= n; i++)
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        System.out.print(cnt);
    }
}