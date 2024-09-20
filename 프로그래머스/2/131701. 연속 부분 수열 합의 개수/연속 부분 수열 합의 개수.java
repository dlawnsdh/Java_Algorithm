import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> count = new HashSet<>();
        for (int i = 0; i < elements.length; i++)
            for (int k = 1; k < elements.length; k++) {
                int sum = 0;
                for (int j = 0; j < k; j++)
                    sum += elements[(i + j) % elements.length];
                count.add(sum);
            }
        return count.size() + 1;
    }
}