import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strs = s.split(" ");
        int[] arr = Arrays.stream(strs).mapToInt(i -> Integer.parseInt(i)).toArray();
        Arrays.sort(arr);
        answer = String.format("%d %d", arr[0], arr[arr.length - 1]);
        return answer;
    }
}