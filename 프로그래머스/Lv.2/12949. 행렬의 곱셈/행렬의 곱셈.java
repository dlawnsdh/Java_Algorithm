import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) 
            for (int j = 0; j < arr2[0].length; j++) {
                int sum = 0;
                for (int h = 0; h < arr2.length; h++) 
                    sum += arr1[i][h] * arr2[h][j];
                result[i][j] = sum;
            }
        return result;
    }
}