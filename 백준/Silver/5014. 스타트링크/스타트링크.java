import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int[] ud = {Integer.parseInt(st.nextToken()), -Integer.parseInt(st.nextToken())};
        int[] dist = new int[f + 1];
        Arrays.fill(dist, -1);
        
        LinkedList<Integer> q = new LinkedList<>();
        dist[s] = 0;
        q.add(s);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == g) {
                System.out.println(dist[cur]);
                return;
            }
            for (int i : ud) {
                int nx = cur + i;
                if (nx < 1 || nx > f) continue;
                if (dist[nx] >= 0) continue;
                dist[nx] = dist[cur] + 1;
                q.add(nx);
            }
        }
        System.out.println("use the stairs");
    }
}