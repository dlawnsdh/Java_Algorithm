import java.util.*;
import java.io.*;

public class Main {
    static boolean check(int[][] arr, int n, int m) {
        for (int i = 0; i < n; i++)
            for (int k = 0; k < m; k++)
                if (arr[i][k] == 1)
                    return false;
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) return;
            
            int[][] arr = new int[n][m];
            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++)
                    arr[i][k] = Integer.parseInt(st.nextToken());
            }
            if (check(arr, n, m)) {
                System.out.println(0);
                continue;
            }
            
            int max = 1;
            for (int i = 1; i < n; i++)
                for (int k = 1; k < m; k++) 
                    if (arr[i][k] == 1) {
                        arr[i][k] = Math.min(Math.min(arr[i - 1][k], arr[i][k - 1]), arr[i - 1][k - 1]) + 1;
                        max = Math.max(max, arr[i][k]);
                    }
            System.out.println(max);
        }
    }
}