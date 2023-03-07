import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int sum = 0;
        Arrays.sort(score);
        for (int i =  score.length % m; i < score.length; i += m) {
            int[] arr = Arrays.copyOfRange(score, i, i + m);
            sum += arr[0] * m;
        }
        return sum;
    }
}