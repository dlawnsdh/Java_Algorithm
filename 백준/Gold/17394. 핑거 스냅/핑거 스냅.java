import java.util.*;
import java.io.*;

public class Main {
    static int bfs(int n, int a, int b) {
        int[] dx = {1, -1};
        int[] dist = new int[Math.max(n, b) + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        dist[n] = 0;
        q.add(n);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur >= a && cur <= b && isPrime(cur))
                return dist[cur];
            for (int i = 0; i < 4; i++) {
                int nx;
                if (i == 2) nx = cur / 2;
                else if (i == 3) nx = cur / 3;
                else nx = cur + dx[i];
                if (nx < 0 || nx >= dist.length || dist[nx] >= 0) continue;
                dist[nx] = dist[cur] + 1;
                q.add(nx);
            }
        }
        return -1;
    }
    
    static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0) return false;
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        while (t > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            System.out.println(bfs(n, a, b));
            t--;
        }
    }
}