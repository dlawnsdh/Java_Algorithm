import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if (n == k) {
            System.out.print(0);
            return;
        }
        
        int[] dist = new int[100001];
        int[] dx = {-1, 1};
        LinkedList<Integer> q = new LinkedList<>();
        Arrays.fill(dist, -1);
        
        q.add(n);
        dist[n] = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 2) nx = x * 2;
                else nx = x + dx[i];
                if (nx < 0 || nx > 100000) continue;
                if (dist[nx] >= 0) continue;
                dist[nx] = dist[x] + 1;
                q.add(nx);
                if (nx == k) {
                    System.out.print(dist[nx]);
                    return;
                }
            }
        }
    }
}