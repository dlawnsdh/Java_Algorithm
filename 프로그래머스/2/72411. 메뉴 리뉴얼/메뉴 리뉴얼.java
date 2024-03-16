import java.util.*;

class Solution {
    Map<String, Integer> menu = new HashMap<>();
    Map<Integer, Integer> max = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        for (String order : orders) 
            for (int c : course)
                combination(order.toCharArray(), new boolean[order.length()], 0, c);
        
        menu.entrySet()
            .stream()
            .sorted((e1, e2) -> e2.getValue() - e1.getValue())
            .forEach(e -> max.put(
                e.getKey().length(),
                Math.max(max.getOrDefault(e.getKey().length(), 0), e.getValue())));

        return menu.entrySet()
            .stream()
            .filter(e -> e.getValue() == max.get(e.getKey().length()) && e.getValue() > 1)
            .map(Map.Entry::getKey)
            .sorted()
            .toArray(String[]::new);
    }
    
    public void combination(char[] arr, boolean[] visited, int st, int r) {
        if (r == 0) {
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < arr.length; i++)
                if (visited[i]) 
                    b.append(arr[i]);
            convert(b.toString().toCharArray());
            return;
        }
        for (int i = st; i < arr.length; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, r - 1);
            visited[i] = false;        
        }
    }
    
    public void convert(char[] arr) {
        StringBuilder b = new StringBuilder();
        Arrays.sort(arr);
        for (char c : arr)
            b.append(c);
        menu.put(b.toString(), menu.getOrDefault(b.toString(), 0) + 1);
    }
}