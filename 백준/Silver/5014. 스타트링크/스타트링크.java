import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int f = sc.nextInt(); int s = sc.nextInt(); int g = sc.nextInt();
        int u = sc.nextInt(); int d = sc.nextInt();
        int[] dist = new int[f + 1];
        boolean[] visited = new boolean[f + 1];
        int[] dx = {u, -1 * d};
        
        if (s == g) {
            System.out.print(0);
            return;
        }
        
        q.add(s);
        visited[s] = true;
        while (!q.isEmpty()) {
            int x = q.peek();
            q.poll();
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];
                if (nx < 1 || nx > f || visited[nx]) continue;
                dist[nx] = dist[x] + 1;
                q.add(nx);
                visited[nx] = true;
            }
        }
        
        if (visited[g]) System.out.print(dist[g]);
        else System.out.print("use the stairs");
    }
}