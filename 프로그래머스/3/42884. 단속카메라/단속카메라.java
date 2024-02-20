import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] tmp = {-30001, -30001};
    public int cnt = 0;
    
    public int solution(int[][] routes) {
        Arrays.stream(routes)
            .sorted((arr1, arr2) -> { 
                if (arr1[1] == arr2[1]) 
                    return Integer.compare(arr1[0], arr2[0]);
                return Integer.compare(arr1[1], arr2[1]);
            }).forEach(route -> {
                if (route[0] > tmp[1]) {
                    cnt++;
                    tmp = route;
                }
            });
        return cnt;
    }
}