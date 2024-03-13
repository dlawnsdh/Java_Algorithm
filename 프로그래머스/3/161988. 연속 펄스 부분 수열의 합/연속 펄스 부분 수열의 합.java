import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int p = 1;
        for (int i = 0; i < n; i++) {
            arr1[i] = sequence[i] * p;
            arr2[i] = sequence[i] * p * -1;
            p *= -1;
        }
        
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        dp1[0] = arr1[0];
        dp2[0] = arr2[0];
        for (int i = 1; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 1] + arr1[i], arr1[i]);
            dp2[i] = Math.max(dp2[i - 1] + arr2[i], arr2[i]);
        }
        
        Arrays.sort(dp1);
        Arrays.sort(dp2);
        return Math.max(dp1[n - 1], dp2[n - 1]);
    }
}