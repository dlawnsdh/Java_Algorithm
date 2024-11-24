import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int[] minCost = new int[4];
    static int min = Integer.MAX_VALUE;
    static List<String> l = new ArrayList<>();
    
    static boolean check(int[] info) {
        int[] sum = new int[4];
        for (int i : info) {
            sum[0] += arr[i][0];
            sum[1] += arr[i][1];
            sum[2] += arr[i][2];
            sum[3] += arr[i][3];
        }

        return sum[0] >= minCost[0] && sum[1] >= minCost[1] && sum[2] >= minCost[2] && sum[3] >= minCost[3];
    }
    
    static void dfs(int[] info, int d, int st, int r) {
        if (d == r) {
            if (check(info)) {
                int sum = 0;
                for (int i : info)
                    sum += arr[i][4];
                if (min >= sum) {
                    if (min > sum)
                        l.clear();
                    StringBuilder sb = new StringBuilder();
                    for (int i : info)
                        sb.append(i + 1).append(' ');
                    l.add(sb.toString());
                    min = sum;
                }
            }
        } else {
            for (int i = st; i < arr.length; i++) {
                visited[i] = true;
                info[d] = i;
                dfs(info, d + 1, i + 1, r);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            minCost[i] = Integer.parseInt(st.nextToken());
        arr = new int[n][5];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < 5; k++)
                arr[i][k] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++)
            dfs(new int[i], 0, 0, i);
        if (min == Integer.MAX_VALUE) System.out.print(-1);
        else {
            Collections.sort(l);
            System.out.println(min);
            System.out.print(l.get(0));
        }
    }
}