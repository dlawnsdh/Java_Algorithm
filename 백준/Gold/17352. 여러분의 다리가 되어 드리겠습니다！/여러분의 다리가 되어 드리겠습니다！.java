import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> g = new ArrayList<>();
    static boolean[] visited;
    
    static void dfs(int n) {
        visited[n] = true;
        for (int i = 0; i < g.get(n).size(); i++) {
            int nx = g.get(n).get(i);
            if (!visited[nx])
                dfs(nx);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int i = 0; i < n - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g.get(a).add(b);
            g.get(b).add(a);
        }
        
        dfs(1);
        for (int i = 1; i <= n; i++)
            if (!visited[i]) {
                System.out.print(1 + " " + i);
                break;
            }
    }
}