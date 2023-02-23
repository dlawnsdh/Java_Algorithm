class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        for (int i = 0; i < arr1.length; i++)
            for (int k = 0; k < arr1[i].length; k++)
                arr2[i][k] += arr1[i][k];
        return arr2;
    }
}