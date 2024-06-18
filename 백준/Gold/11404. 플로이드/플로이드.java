import java.util.*;
import java.io.*;

public class Main {
    static int INF = 1000000000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = Math.min(arr[a][b], c);
        }
        
        for (int i = 1; i <= n; i++)
            for (int k = 1; k <= n; k++)
                for (int j = 1; j <= n;j++)
                    arr[k][j] = Math.min(arr[k][j], arr[k][i] + arr[i][j]);
        
        StringBuilder b = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= n; k++) {
                if (arr[i][k] == INF) b.append(0);
                else b.append(arr[i][k]);
                b.append(' ');
            }
            b.append('\n');
        }
        System.out.print(b);
    }
}