import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] arr = new int[score.length];
        int[] m = new int[k];
        
        if (k > score.length)    
            m = Arrays.copyOfRange(score, 0, score.length);
        else m = Arrays.copyOfRange(score, 0, k);
        
        Arrays.sort(m);
        arr[0] = score[0];
        
        for (int i = 1; i < score.length; i++)
            arr[i] = Math.min(arr[i - 1], score[i]);
        
        for (int i = k; i < score.length; i++) {
            if (score[i] > m[0]) {
                m[0] = score[i];
                Arrays.sort(m);
            }
            arr[i] = m[0];
        }
        return arr;
    }
}