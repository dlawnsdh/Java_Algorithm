import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        LinkedList<Integer> q = new LinkedList<>();
        int[] dist = new int[1000001];
        Arrays.fill(dist, -1);
        
        int cnt = 0;
        dist[x] = 0;
        q.add(x);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == y) break;
            for (int i = 1; i <= 3; i++) {
                int nx;
                if (i == 1) nx = cur + n;
                else nx = cur * i;
                if (nx > 1000000 || dist[nx] >= 0) continue;
                dist[nx] = dist[cur] + 1;
                q.add(nx);
            }
        }
        return dist[y];
    }
}