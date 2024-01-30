import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr1 = s.split(" ");
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++)
            arr2[i] = Integer.parseInt(arr1[i]);
        Arrays.sort(arr2);
        return String.valueOf(arr2[0]) + " " + String.valueOf(arr2[arr2.length - 1]);
    }
}