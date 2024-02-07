import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> l = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();
        for (char i = 'A'; i <= 'Z'; i++)
            m.put(String.valueOf(i), (int) (i - 64));
        
        int idx = 27;
        for (int i = 0; i < msg.length(); i++) {
            boolean flag = true;
            String tmp = "";
            for (int k = i + 1; k <= msg.length(); k++) {
                tmp = msg.substring(i, k);
                if (!m.containsKey(tmp)) {
                    i = k - 2;
                    flag = false;
                    l.add(m.get(tmp.substring(0, tmp.length() - 1)));
                    break;
                }
            }
            if (flag) {
                l.add(m.get(tmp));
                break;
            }
            m.put(tmp, idx);
            idx++;
        }
        
        return l.stream().mapToInt(Integer::intValue).toArray();
    }
}