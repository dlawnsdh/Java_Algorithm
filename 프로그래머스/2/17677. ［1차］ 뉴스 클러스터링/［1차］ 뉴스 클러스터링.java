import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        
        for (int i = 0; i < str1.length() - 1; i++)
            if (Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i + 1))) {
                String s = String.valueOf(str1.charAt(i)) + String.valueOf(str1.charAt(i + 1));
                m1.put(s, m1.getOrDefault(s, 0) + 1);
            }
        for (int i = 0; i < str2.length() - 1; i++)
            if (Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i + 1))) {
                String s = String.valueOf(str2.charAt(i)) + String.valueOf(str2.charAt(i + 1));
                m2.put(s, m2.getOrDefault(s, 0) + 1);
            }
    
        double g = m1.keySet().stream()
            .filter(key -> m2.containsKey(key))
            .mapToDouble(k -> (double) Math.min(m1.get(k), m2.get(k)))
            .sum();
        m2.keySet().stream().forEach(key -> { 
            m1.put(key, Math.max(m1.getOrDefault(key, 0), m2.get(key)));
        });
        double h = m1.values().stream()
            .mapToDouble(v -> (double) v)
            .sum();
        
        return g == 0 && h == 0 ? 65536 : (int) (g / h * 65536);
    }
}