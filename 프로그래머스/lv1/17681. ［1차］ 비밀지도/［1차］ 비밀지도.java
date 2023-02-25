import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map = new String[arr1.length];
        for (int i = 0; i < arr1.length; i++) { 
            String s = Integer.toBinaryString(arr1[i] | arr2[i]);
            map[i] = s.length() < n ? "0".repeat(n - s.length()) + s : s;
        }
        
        for (int i = 0; i < map.length; i++) {
            map[i] = map[i].replace('0', ' ');
            map[i] = map[i].replace('1', '#');
        }
        return map;
    }
}