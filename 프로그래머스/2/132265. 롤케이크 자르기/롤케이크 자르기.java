import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        for (int i : topping)
            m2.put(i, m2.getOrDefault(i, 0) + 1);
        
        int cnt = 0;
        for (int i = 0; i < topping.length; i++) {
            m1.put(topping[i], m1.getOrDefault(topping[i], 0) + 1);
            m2.put(topping[i], m2.getOrDefault(topping[i], 0) - 1);
            if (m2.get(topping[i]) <= 0)
                m2.remove(topping[i]);
            if (m1.size() == m2.size())
                cnt++;
        }
        return cnt;
    }
}