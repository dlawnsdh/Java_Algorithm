import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int cnt = 0;
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> m = new HashMap<>();
            for (int k = i; k < i + 10; k++)
                m.put(discount[k], m.getOrDefault(discount[k], 0) + 1);
            
            boolean flag = true;
            for (int k = 0; k < want.length; k++) {
                if (!m.containsKey(want[k]) || m.get(want[k]) != number[k])
                    flag = false;
            }
            if (flag) cnt++;
        }
        return cnt;
    }
}