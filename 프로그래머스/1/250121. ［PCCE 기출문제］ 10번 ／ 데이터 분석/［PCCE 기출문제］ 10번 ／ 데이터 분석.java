import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> l = new ArrayList<>(Arrays.asList(data));
        Map<String, Integer> m = new HashMap<>() {{
            put("code", 0);
            put("date", 1);
            put("maximum", 2);
            put("remain", 3);
        }};
        l = l.stream().filter(arr -> arr[m.get(ext)] < val_ext).collect(Collectors.toList());
     
        int k = m.get(sort_by);
        l.sort((arr1, arr2) -> Integer.compare(arr1[k], arr2[k])); //람다식으로 sort_by 인자에 따라 정렬
        return l.toArray(new int[l.size()][4]);
    }
}