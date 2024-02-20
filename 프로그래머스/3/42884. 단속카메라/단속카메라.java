import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (arr1, arr2) -> Integer.compare(arr1[1], arr2[1]));
        
        int[] tmp = routes[0];
        int cnt = 1;
        for (int i = 1; i < routes.length; i++)
            if (routes[i][0] > tmp[1]) {
                cnt++;
                tmp = routes[i];
            }
        return cnt;
    }
}