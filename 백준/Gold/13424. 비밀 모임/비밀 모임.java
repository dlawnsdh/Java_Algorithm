import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        while (t --> 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] map = new int[n + 1][n + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(map[i], 1000000000);
                map[i][i] = 0;
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[a][b] = c;
                map[b][a] = c;
            }
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[k];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            
            for (int h = 1; h <= n; h++)
                for (int i = 1; i <= n; i++)
                    for (int j = 1; j <= n; j++)
                        if (map[i][j] > map[i][h] + map[h][j])
                            map[i][j] = map[i][h] + map[h][j];
            
            int[][] total = new int[n + 1][2];
            for (int i = 1; i <= n; i++)
                total[i][0] = i;
            for (int i = 0; i < k; i++) 
                for (int j = 1; j <= n; j++)
                    total[j][1] += map[arr[i]][j];
            Arrays.sort(total, (a, b) -> a[1] - b[1]);
            System.out.println(total[1][0]);
        }
    }
}