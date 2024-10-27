import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 1;
            dist[b][a] = -1;
        }
        
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] == 1 && dist[k][j] == 1)
                        dist[i][j] = 1;
                    else if (dist[i][k] == -1 && dist[k][j] == -1)
                        dist[i][j] = -1;
                }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int big = 0;
            int small = 0;
            for (int k = 1; k <= n; k++) {
                if (dist[i][k] == 1) big++;
                else if (dist[i][k] == -1) small++;
            }
            if (big >= n / 2 + 1 || small >= n / 2 + 1)
                count++;
        }
        System.out.print(count);
    }
}