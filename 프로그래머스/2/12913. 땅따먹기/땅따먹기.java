import java.util.*;

class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int k = 0; k < 4; k++) {
                int tmp = land[i][k];
                for (int j = 0; j < 4; j++)
                    if (j != k)
                        tmp = Math.max(tmp, land[i][k] + land[i - 1][j]);
                land[i][k] = tmp;
            }
        }
        
        Arrays.sort(land[land.length - 1]);
        return land[land.length - 1][3];
    }
}