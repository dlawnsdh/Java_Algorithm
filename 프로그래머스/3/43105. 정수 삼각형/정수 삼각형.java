import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        List<int[]> dp = new ArrayList<>();
        for (int i = 1; i <= triangle.length; i++)
            dp.add(new int[i]);
        
        dp.set(0, triangle[0]);
        for (int i = 0; i < triangle.length - 1; i++) {
            int[] arr1 = dp.get(i);
            int[] arr2 = dp.get(i + 1);
            for (int k = 0; k < arr1.length; k++) {
                arr2[k] = Math.max(arr2[k], arr1[k] + triangle[i + 1][k]);
                arr2[k + 1] = Math.max(arr2[k + 1], arr1[k] + triangle[i + 1][k + 1]);
            }
        }
        Arrays.sort(dp.get(triangle.length - 1));
        return dp.get(triangle.length - 1)[triangle.length - 1];
    }
}