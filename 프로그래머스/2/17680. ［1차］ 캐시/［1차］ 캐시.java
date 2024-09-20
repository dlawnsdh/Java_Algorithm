import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0)
            return cities.length * 5;
        
        Set<String> cache = new LinkedHashSet<>();
        for (int i = 0; i < cities.length; i++)
            cities[i] = cities[i].toLowerCase();
        
        int total = 0;
        for (String city : cities) {
            if (cache.contains(city)) {
                cache.remove(city);
                total++;
            } else {
                if (cache.size() == cacheSize)
                    cache.remove(cache.iterator().next());
                total += 5;
            }
            cache.add(city);
        }
        return total;
    }
}