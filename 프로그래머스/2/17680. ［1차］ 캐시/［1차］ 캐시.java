import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> q = new LinkedList<>();
        Set<String> s = new HashSet<>();
        
        if (cacheSize == 0) return cities.length * 5;
        int cnt = 0;
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (s.contains(city)) {
                q.remove(city);
                cnt++;
            } else {
                if (q.size() < cacheSize)
                    s.add(city);
                else {
                    s.remove(q.poll());
                    s.add(city);
                }
                cnt += 5;
            }
            q.add(city);
        }
        return cnt;
    }
}