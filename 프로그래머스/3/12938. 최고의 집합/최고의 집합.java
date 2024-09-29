import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) 
            return new int[] {-1};
        
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s / n--;
            s -= arr[i];
        }
        return arr;
    }
}