import java.util.*;

class Solution {
    List<Set<String>> l = new ArrayList<>();
    int count = 0;
    
    public int solution(String[] user_id, String[] banned_id) {
        permutation(user_id, banned_id, new String[banned_id.length], new boolean[user_id.length], banned_id.length, 0, 0);
        return l.size();
    }
    
    public void permutation(String[] u, String[] b, String[] result, boolean[] visited, int d, int k, int idx) {
        if (d == k) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < result.length; i++)
                set.add(result[i]);
            if (!l.contains(set))
                l.add(set);
            return;
        }
        for (int i = 0; i < u.length; i++)
            if (!visited[i] && match(u[i], b[idx])) {
                visited[i] = true;
                result[k] = u[i];
                permutation(u, b, result, visited, d, k + 1, idx + 1);
                visited[i] = false;
            }
    }
    
    public boolean match(String u, String b) {
        if (u.length() != b.length()) return false;
        for (int i = 0; i < u.length(); i++)
            if (u.charAt(i) != b.charAt(i) && b.charAt(i) != '*')
                return false;
        return true;
    }
}