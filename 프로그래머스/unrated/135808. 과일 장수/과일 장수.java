import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int sum = 0;
        Arrays.sort(score);
        for (int i =  score.length % m; i < score.length; i += m) 
            sum += score[i] * m;
        
        return sum;
    }
}
