import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        int k = 2;
        while (true) {
            int cnt = 0;
            for (int i = 0; i < arr.length - 1; i++)
                if (max % arr[i] == 0)
                    cnt++;
            if (cnt == arr.length - 1) break;
            max = arr[arr.length - 1] * k++;
        }
        return max;
    }
}