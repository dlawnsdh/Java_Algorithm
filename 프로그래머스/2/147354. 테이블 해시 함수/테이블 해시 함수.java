import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (arr1, arr2) -> {
           if (arr1[col - 1] == arr2[col - 1])
               return -Integer.compare(arr1[0], arr2[0]);
            return Integer.compare(arr1[col - 1], arr2[col - 1]);
        });
        
        int[] arr = new int[data.length];
        int xor = 0;
        for (int i = 0; i < data.length; i++) {
            int sum = 0;
            for (int k = 0; k < data[i].length; k++)
                sum += data[i][k] % (i + 1);
            arr[i] = sum;
        }
        for (int i = row_begin - 1; i < row_end; i++)
            xor = xor ^ arr[i];
        return xor;
    }
}