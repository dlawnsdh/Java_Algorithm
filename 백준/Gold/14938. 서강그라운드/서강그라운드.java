import java.util.*;
import java.io.*;

public class Main {
    static int INF = 200000000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[][] map = new int[n + 1][n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = c;
            map[b][a] = c;
        }
        
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (map[i][j] > map[i][k] + map[k][j])
                        map[i][j] = map[i][k] + map[k][j];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int k = 1; k <= n; k++) {
                if (map[i][k] <= m)
                    sum += arr[k];
            }
            max = Math.max(max, sum);
        }
        System.out.print(max);
    }
}