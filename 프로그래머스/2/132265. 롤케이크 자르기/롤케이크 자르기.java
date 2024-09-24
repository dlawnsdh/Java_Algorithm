import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> l = new HashMap<>();
        Map<Integer, Integer> r = new HashMap<>();
        for (int t : topping)
            r.compute(t, (k, v) -> v == null ? 1 : v + 1);
        
        int count = 0;
        for (int t : topping) {
            r.compute(t, (k, v) -> v - 1);
            l.compute(t, (k, v) -> v == null ? 1 : v + 1);
            if (r.get(t) == 0 ) 
                r.remove(t);
            if (l.keySet().size() == r.keySet().size())
                count++;
        }
        return count;
    }
}