import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 0; i < results.length; i++) {
            dist[results[i][0]][results[i][1]] = 1;
            dist[results[i][1]][results[i][0]] = -1;
        }
        
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] == 1 && dist[k][j] == 1)
                        dist[i][j] = 1;
                    else if (dist[i][k] == -1 && dist[k][j] == -1)
                        dist[i][j] = -1;
                }
        
        return (int) Arrays.stream(dist)
                .mapToInt(arr -> (int) Arrays.stream(arr)
                        .filter(i -> i != 0)
                        .count())
                .filter(cnt -> cnt == n - 1)
                .count();
    }
}