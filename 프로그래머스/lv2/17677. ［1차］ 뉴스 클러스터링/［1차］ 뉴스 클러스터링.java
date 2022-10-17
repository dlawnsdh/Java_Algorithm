import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            if (Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i + 1))) {
                String str = Character.toString(str1.charAt(i)) + Character.toString(str1.charAt(i + 1));
                if (map1.containsKey(str))
                    map1.put(str, map1.get(str) + 1);
                else map1.put(str, 1);
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            if (Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i + 1))) {
                String str = Character.toString(str2.charAt(i)) + Character.toString(str2.charAt(i + 1));
                if (map2.containsKey(str))
                    map2.put(str, map2.get(str) + 1);
                else map2.put(str, 1);
            }
        }
        if (map1.size() == 0 && map2.size() == 0) return 65536;
    
        ArrayList<String> result1 = new ArrayList<>();
        ArrayList<String> result2 = new ArrayList<>();
        
        Iterator<String> keys1 = map1.keySet().iterator();
        while (keys1.hasNext()) {
            String key = keys1.next();
            if (map2.containsKey(key)) {
                int n = Math.min(map1.get(key), map2.get(key));
                for (int i = 0; i < n; i++)
                    result1.add(key);
            }
            for (int i = 0; i < map1.get(key); i++)
                result2.add(key);
        }
        Iterator<String> keys2 = map2.keySet().iterator();
        while (keys2.hasNext()) {
            String key = keys2.next();
            for (int i = 0; i < map2.get(key); i++)
                result2.add(key);
        }
        
        for (int i = 0; i < result1.size(); i++)
            result2.remove(result1.get(i));
        
        double k = (double) result1.size() / (double) result2.size();
        return (int) (k * 65536);
    }
}