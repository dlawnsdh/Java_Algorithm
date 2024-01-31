import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> s = new HashSet<>();
        
        for (int i = 0; i < elements.length; i++) {
            int sum = elements[i];
            s.add(sum);
            for (int k = i + 1; k < elements.length + i; k++) { 
                sum += elements[k % elements.length];
                s.add(sum);
            }
        }
        return s.size();
    }
}