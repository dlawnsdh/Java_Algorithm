import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] arr = new int[n];
        if (n > s) return new int[] {-1};
        Arrays.fill(arr, s / n);
        for (int i = n - 1; i >= n - s % n; i--)
            arr[i]++;
        return arr;
    }
}