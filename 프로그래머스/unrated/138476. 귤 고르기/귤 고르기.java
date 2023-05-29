import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> m = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            if (!m.containsKey(tangerine[i]))
                m.put(tangerine[i], 1);
            else 
                m.put(tangerine[i], m.get(tangerine[i]) + 1);
        }
        
        int cnt = 0;
        int sum = 0;
        List<Integer> list = new ArrayList<>(m.values());
        list.sort(Integer::compareTo);
        
        for (int i = list.size() - 1; i > -1; i--) {
            if (sum + list.get(i) < k) {
                sum += list.get(i);
                cnt++;
            }
            else {
                cnt++;
                break;
            }
        }
        
       return cnt;
    }
}