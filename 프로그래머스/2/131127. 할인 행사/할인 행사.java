import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> m = new HashMap<>();
        int count = 0;
        for (int i = 0; i < discount.length; i++) {
            if (i < 10) 
                m.compute(discount[i], (k, v) -> v == null ? 1 : v + 1);
            else {
                m.compute(discount[i], (k, v) -> v == null ? 1 : v + 1);
                m.compute(discount[i - 10], (k, v) -> v - 1);
                if (m.get(discount[i - 10]) == 0)
                    m.remove(discount[i - 10]);
            }
            if (i >= 9) {
                boolean flag = true;
                for (int k = 0; k < want.length; k++)
                    if (!m.containsKey(want[k]) || m.get(want[k]) != number[k]) {
                        flag = false;
                        break;
                    }
                if (flag) count++;
            }
        }
        return count;
    }
}