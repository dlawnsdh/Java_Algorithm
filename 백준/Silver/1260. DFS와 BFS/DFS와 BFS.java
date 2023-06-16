import java.util.*;
public class Main {
    public static boolean[] visited = new boolean[1001];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    static void dfs(int x) {
        visited[x] = true;
        System.out.print(x + " ");
        for (int i = 0; i < graph.get(x).size(); i++)
            if (!visited[graph.get(x).get(i)])
                dfs(graph.get(x).get(i));
    }
    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;
        System.out.print(x + " ");
        while(!q.isEmpty()) {
            int k = q.poll();
            for (int i = 0; i < graph.get(k).size(); i++) {
                int y = graph.get(k).get(i);
                if (!visited[y]) {
                    System.out.print(y + " ");
                    visited[y] = true;
                    q.add(y);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); int m = s.nextInt(); int v = s.nextInt();

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < m; i++) {
            int x = s.nextInt(); int y = s.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        for (int i = 0; i < graph.size(); i++)
            Collections.sort(graph.get(i));

        dfs(v);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(v);
    }
}