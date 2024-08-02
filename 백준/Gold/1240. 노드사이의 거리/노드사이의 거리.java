import java.util.*;
import java.io.*;

public class Main {
    static List<List<int[]>> g = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();
    
    static void dfs(int n, int en, int sum, boolean[] visited) {
        if (n == en) {
            result.add(sum);
            return;
        }

        for (int i = 0; i < g.get(n).size(); i++) {
            int[] nx = g.get(n).get(i);
            if (!visited[nx[0]]) {
                visited[nx[0]] = true;
                dfs(nx[0], en, sum + nx[1], visited);
                visited[nx[0]] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) 
            g.add(new ArrayList<>());
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g.get(a).add(new int[] {b, c});
            g.get(b).add(new int[] {a, c});
        }
        
        while (m --> 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            boolean[] visited = new boolean[n + 1];
            visited[a] = true;
            dfs(a, b, 0, visited);
        }
        for (int dist : result)
            System.out.println(dist);
    }
}