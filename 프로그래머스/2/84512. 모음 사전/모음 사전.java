import java.util.*;

class Solution {
    String[] arr = {"A", "E", "I", "O", "U"}; 
    Map<String, Integer> m = new HashMap<>();
    int count = 1;
    
    void dfs(String word, int depth) {
        if (depth == 5)
            return;
        for (int i = 0; i < 5; i++) {
            m.put(word + arr[i], count++);
            dfs(word + arr[i], depth + 1);
        }
    }
    
    public int solution(String word) {
        dfs("", 0);
        return m.get(word);
    }
}