import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        int idx = 2;
        while (true) {
            boolean flag = true;
            for (int i = 0; i < arr.length - 1; i++)
                if (max % arr[i] != 0) {
                    flag = false;
                    break;
                }
            if (flag) return max;
            max = arr[arr.length - 1] * idx++;
        }
    }
}