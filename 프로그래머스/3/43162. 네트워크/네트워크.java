import java.util.*;

class Solution {
    public List<List<Integer>> graph = new ArrayList<>();
    public boolean[] visited = new boolean[200];
    
    public void dfs(int x) {
        visited[x] = true;
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y])
                dfs(y);
        }
    }
    
    public int solution(int n, int[][] computers) {
        for (int i = 0; i < computers.length; i++) {
            graph.add(new ArrayList<>());
            for (int k = 0; k < computers.length; k++)
                if (computers[i][k] == 1)
                    graph.get(i).add(k);
        }
        
        int cnt = 0;
        for (int i = 0; i < computers.length; i++)
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        return cnt;
    }
}