import java.util.*;

class Solution {
    public String solution(String s) {
        int[] arr = Arrays.stream(s.split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        Arrays.sort(arr);
        StringBuilder b = new StringBuilder();
        b.append(arr[0]).append(" ").append(arr[arr.length - 1]);
        return b.toString();
    }
}