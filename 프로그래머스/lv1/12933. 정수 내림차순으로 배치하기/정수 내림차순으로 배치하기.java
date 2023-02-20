import java.util.*;

class Solution {
    public long solution(long n) {
        String str = "";
        String[] s = Long.toString(n).split("");
        Integer[] arr = new Integer[s.length];
        for (int i = 0; i < s.length; i++)
            arr[i] = Integer.parseInt(s[i]);
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++)
            str += Integer.toString(arr[i]);
        return Long.parseLong(str);            
    }
}