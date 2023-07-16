import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int n = sc.nextInt(); int k = sc.nextInt();
        int[] dist = new int[100001];
        boolean[] visited = new boolean[100001];
        int[] dx = {-1, 1};
        
        q.add(n);
        visited[n] = true;
        while (!q.isEmpty()) {
            int x = q.peek();
            q.poll();
            for (int i = 0; i < 3; i++) {
                int nx;
                if (i != 2) nx = x + dx[i];
                else nx = 2 * x;
                if (nx < 0 || nx >= dist.length || visited[nx]) continue;
                dist[nx] = dist[x] + 1;
                visited[nx] = true;
                q.add(nx);
            }
        }
        System.out.print(dist[k]);
    }
}