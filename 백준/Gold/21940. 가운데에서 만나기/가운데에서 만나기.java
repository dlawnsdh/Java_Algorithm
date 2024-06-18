import java.util.*;
import java.io.*;

public class Main {
    static int INF = 100000000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
        }
        int num = Integer.parseInt(br.readLine());
        int[] nums = new int[num];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
        int min = Integer.MAX_VALUE;
        int[] max = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k < num; k++)
                max[i] = Math.max(max[i], arr[nums[k]][i] + arr[i][nums[k]]);
            min = Math.min(min, max[i]);
        }
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            if (max[i] <= min)
                l.add(i);  
        l.stream().sorted().forEach(i -> System.out.print(i + " "));
    }
}