import java.util.*;

class Solution {
    List<List<int[]>> g = new ArrayList<>();
    
    public int solution(int N, int[][] road, int K) {
        for (int i = 0; i <= N; i++)
            g.add(new ArrayList<>());
        for (int[] r : road) {
            g.get(r[0]).add(new int[] {r[1], r[2]});
            g.get(r[1]).add(new int[] {r[0], r[2]});
        }
        
        // 다익스트라 알고리즘 사용 -> 우선순위 큐로 가중치가 작은 것 부터 확인
        // pq 첫 번째 원소는 노드 번호 두 번째 원소는 해당 노드로의 가중치 따라서 해당 노드로의 가중치가 작은 순서대로 큐에 정렬됨
        PriorityQueue<int[]> q = new PriorityQueue<>((arr1, arr2) -> arr1[1] - arr2[1]);
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        q.add(new int[] {1, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < g.get(cur[0]).size(); i++) {
                int[] x = g.get(cur[0]).get(i);
                // 해당 노드를 방문 했더라도 더 작은 가중치가 존재하면 갱신하고 아니면 무시
                if (dist[x[0]] >= 0 && dist[x[0]] <= dist[cur[0]] + x[1])
                    continue;
                dist[x[0]] = dist[cur[0]] + x[1];
                q.add(x);
            }
        }
        
        return (int) Arrays.stream(dist).filter(i -> i <= K).count() - 1;
    }
}