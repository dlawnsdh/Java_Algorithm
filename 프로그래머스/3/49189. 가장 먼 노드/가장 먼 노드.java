import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int[] arr : edge) {
            g.get(arr[0]).add(arr[1]);
            g.get(arr[1]).add(arr[0]);
        }
        
        LinkedList<Integer> q = new LinkedList<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < g.get(cur).size(); i++) {
                int x = g.get(cur).get(i);
                if (dist[x] >= 0) continue;
                dist[x] = dist[cur] + 1;
                q.add(x);
            }
        }
        
        Arrays.sort(dist);
        return (int) Arrays.stream(dist).filter(i -> i == dist[n]).count();
    }
}