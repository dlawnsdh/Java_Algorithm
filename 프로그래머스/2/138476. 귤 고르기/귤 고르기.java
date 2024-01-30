import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int[] arr = new int[10000001];
        for (int i : tangerine)
            arr[i]++;
        Arrays.sort(arr);
        
        int sum = 0;
        int cnt =0;
        for (int i = arr.length - 1; i > 0; i--) {
            sum += arr[i];
            cnt++;
            if (sum >= k) 
                break;
        }
        return cnt;
    }
}