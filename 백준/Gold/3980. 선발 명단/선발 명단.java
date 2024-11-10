import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr = new int[11][11];
    static boolean[] visited;
    static int max;
    
    static void dfs(int sum, int d) {
        if (d == 11) {
            if (max < sum)
                max = sum;
        } else {
            for (int i = 0; i < 11; i++) 
                if (!visited[i] && arr[d][i] != 0) {
                    visited[i] = true;
                    dfs(sum + arr[d][i], d + 1);
                    visited[i] = false;
                }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        while (t --> 0) {
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 11; k++)
                    arr[i][k] = Integer.parseInt(st.nextToken());
            }
            
            visited = new boolean[11];
            max = 0;
            dfs(0, 0);
            System.out.println(max);
        }
    }
}