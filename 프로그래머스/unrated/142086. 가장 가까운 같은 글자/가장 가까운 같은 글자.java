import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] arr = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                arr[i] = -1;
            }
            else {
                int n = map.get(s.charAt(i));
                map.put(s.charAt(i), i);
                arr[i] = i - n;
            }
        }
        return arr;
    }
}