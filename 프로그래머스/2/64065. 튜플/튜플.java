import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        s = s.substring(2, s.length() - 2);
        String[] arr = (s.split("}.\\{"));
        Arrays.sort(arr, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        
        List<String> l = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String[] tmp = arr[i].split(",");
            for (int k = 0; k < tmp.length; k++)
                if (!set.contains(tmp[k])) {
                    set.add(tmp[k]);
                    l.add(tmp[k]);
                }
        }
        return l.stream().mapToInt(Integer::parseInt).toArray();
    }
}