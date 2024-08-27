import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int INF = 1000000;
        StringTokenizer st;
        
        
        while (t --> 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(br.readLine());
            int[][] map = new int[p + 1][p + 1];
            for (int i = 1; i <= p; i++) {
                Arrays.fill(map[i], INF);
                map[i][i] = 0;
            }
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[a][b] = Math.min(map[a][b], c);
                map[b][a] = Math.min(map[b][a], c);
            }
            
            for (int k = 1; k <= p; k++)
                for (int i = 1; i <= p; i++)
                    for (int j = 1; j <= p; j++)
                        if (map[i][j] > map[i][k] + map[k][j])
                            map[i][j] = map[i][k] + map[k][j];
            
            long min = Long.MAX_VALUE;
            int num = 0;
            for (int i = 1; i <= p; i++) {
                long sum = 0;
                boolean flag = true;
                for (int k = 0; k < n; k++) {
                    if (map[arr[k]][i] == INF) {
                        flag = false;
                        break;
                    }
                    sum += (long) Math.pow(map[arr[k]][i], 2);
                }
                if (flag && min > sum) {
                    min = sum;
                    num = i;
                }
            }
            System.out.println(num + " " + min);
        }
    }
}