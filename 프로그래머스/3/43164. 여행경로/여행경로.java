import java.util.*;

class Solution {
    List<String> l = new ArrayList<>();
    boolean[] used;
    
    public void dfs (String[][] tickets, String airport, String path, int d) {
        if (d == tickets.length) {
            l.add(path);
            return;
        }
        
        for (int i = 0; i < used.length; i++)
            if (!used[i] && airport.equals(tickets[i][0])) {
                used[i] = true;
                dfs(tickets, tickets[i][1], path + " " + tickets[i][1], d + 1);
                used[i] = false;
            }
    }
    
    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        dfs(tickets, "ICN", "ICN", 0);
        Collections.sort(l);
        return l.get(0).split(" ");
    }
}