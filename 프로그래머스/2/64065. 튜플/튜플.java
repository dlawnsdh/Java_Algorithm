import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[][] arr = Arrays.stream(s.substring(2, s.length() - 2).split("},\\{"))
            .map(str -> {
                return Arrays.stream(str.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            })
            .toArray(int[][]::new);
        Arrays.sort(arr, (a, b) -> a.length - b.length);
        
        Set<Integer> tuple = new LinkedHashSet<>();
        for (int[] a : arr)
            for (int i : a)
                tuple.add(i);
        return tuple.stream().mapToInt(Integer::intValue).toArray();
    }
}