import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> m = new HashMap<>();
        for (String[] arr : clothes) 
            m.put(arr[1], m.getOrDefault(arr[1], 0) + 1);
        
        int sum = 1;
        for (Integer i : m.values())
            sum *= (i + 1);
        return sum - 1;
    }
}