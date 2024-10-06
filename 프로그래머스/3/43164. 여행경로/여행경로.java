import java.util.*;

class Solution {
    PriorityQueue<String> route = new PriorityQueue<>();
    boolean[] visited;
    
    void dfs(String[][] t, String s, int d, int r) {
        if (d == r)
            route.add(s);
        else {
            for (int i = 0; i < t.length; i++)
                if (!visited[i] && s.endsWith(t[i][0])) {
                    visited[i] = true;
                    dfs(t, s + " " + t[i][1], d + 1, r);
                    visited[i] = false;
                }
        }
    }
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", 0, tickets.length);
        return route.poll().split(" ");
    }
}