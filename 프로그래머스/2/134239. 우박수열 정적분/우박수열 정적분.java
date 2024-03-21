import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Double> l = new ArrayList<>();
        while (k > 1) {
            l.add((double) k);
            if (k % 2 != 0) k = k * 3 + 1;
            else k /= 2;
        }
        l.add(1.0);
        
        double[] arr = new double[l.size()];
        for (int i = 1; i < l.size(); i++)
            arr[i] = (l.get(i) - l.get(i - 1)) / 2 + l.get(i - 1); 
        
        double[] result = new double[ranges.length];
        int n = arr.length - 1;
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i][0] > n + ranges[i][1]) 
                result[i] = -1;
            else {
                for (int j = ranges[i][0] + 1; j <= n + ranges[i][1]; j++)
                    result[i] += arr[j];
            }
        }
        return result;
    }
}