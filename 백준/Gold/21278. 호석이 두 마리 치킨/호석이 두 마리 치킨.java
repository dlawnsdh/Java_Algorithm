import java.util.*;
import java.io.*;

public class Main {
    static int INF = 987654321;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 1;
            dist[b][a] = 1;
        }
        
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
    
        int x = 0;
        int y = 0;
        int sum = INF;
        for (int i = 1; i < n; i++)
            for (int k = i + 1; k <= n; k++) {
                int tmp = 0;
                for (int j = 1; j <= n; j++)
                    tmp += Math.min(dist[i][j], dist[k][j]) * 2;
                if (sum > tmp) {
                    x = i;
                    y = k;
                    sum = tmp;
                }
            }
        System.out.printf("%d %d %d", x, y, sum);
    }
}