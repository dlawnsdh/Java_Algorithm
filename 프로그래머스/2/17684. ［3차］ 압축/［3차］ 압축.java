import java.util.*;

class Solution {
    Map<String, Integer> dic = new HashMap<>();
    
    public int[] solution(String msg) {
        int idx = 1;
        while (idx <= 26)
            dic.put(String.valueOf((char) (idx + 64)), idx++);
        
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < msg.length(); i++) {
            String str = "";
            boolean isLastWord = true;
            for (int k = i + 1; k <= msg.length(); k++) {
                str = msg.substring(i, k);
                if (!dic.containsKey(str)) {
                    index.add(dic.get(str.substring(0, str.length() - 1)));
                    isLastWord = false;
                    i = k - 2;
                    break;
                }
            }
            if (isLastWord) {
                index.add(dic.get(str));
                break;
            }
            dic.put(str, idx++);
        }
        return index.stream().mapToInt(Integer::intValue).toArray();
    }
}