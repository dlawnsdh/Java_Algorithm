import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) 
                arr[i][k] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                for (int k = 0; k < m; k++)
                    dp[k][i] = arr[k][i];
            } else {
                for (int k = 0; k < m; k++) {
                    dp[k][i] = dp[k][i - 1] + arr[k][i] / 2;
                    int max = 0;
                    for (int j = 0; j < m; j++)
                        if (j != k)
                            max = Math.max(max, dp[j][i - 1]);
                    dp[k][i] = Math.max(max + arr[k][i], dp[k][i]);
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < m; i++)
            max = Math.max(max, dp[i][n - 1]);
        System.out.print(max);
    }
}