import java.util.*;

class Solution {
    class Word {
        String word;
        int idx;
        
        Word(String w, int i) {
            this.word = w;
            this.idx = i;
        }
    }
    
    boolean isOneAlphabetChanged(String from, String to) {
        int cnt = 0;
        for (int i = 0; i < from.length(); i++)
            if (from.charAt(i) != to.charAt(i))
                cnt++;
        return cnt == 1 ? true : false;
    }
    
    int min = Integer.MAX_VALUE;
    void dfs(String[] words, boolean[] visited, String begin, String target, int count) {
        if (begin.equals(target)) {
            min = Math.min(min, count);
            return;
        } else {
            for (int i = 0; i < words.length; i++)
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(words, visited, words[i], target, count + 1);
                    visited[i] = false;
                }
        }
    } 
    
    int bfs(String[] words, String begin, String target) {
        Queue<Word> q = new LinkedList<>();
        int[] dist = new int[words.length + 1];
        
        Arrays.fill(dist, -1);
        dist[0] = 0;
        q.add(new Word(begin, 0));
        while (!q.isEmpty()) {
            Word cur = q.poll();
            if (cur.word.equals(target))
                return dist[cur.idx];
            for (int i = 0; i < words.length; i++)
                if (isOneAlphabetChanged(cur.word, words[i]) && dist[i + 1] < 0) {
                    dist[i + 1] = dist[cur.idx] + 1;
                    q.add(new Word(words[i], i + 1));
                }
        }
        return 0;
    }
    
    public int solution(String begin, String target, String[] words) {        
        return bfs(words, begin, target);
        // dfs(words, new boolean[words.length], begin, target, 0);
        // return min;
    }
}