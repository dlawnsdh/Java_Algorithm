import java.util.*;
import java.io.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static List<int[]> h = new ArrayList<>();
    static List<int[]> c = new ArrayList<>();
    static boolean[] visited = new boolean[13];
    
    static void dfs(int d, int r, int st) {
        if (d == r) {
            int[] arr = new int[h.size()];
            Arrays.fill(arr, Integer.MAX_VALUE);
            for (int i = 0; i < c.size(); i++) 
                if (visited[i]) {
                    int[] chicken = c.get(i);
                    for (int k = 0; k < h.size(); k++) {
                        int[] house = h.get(k);
                        arr[k] = Math.min(arr[k], Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]));
                    }
                }
            int sum = 0;
            for (int dist : arr)
                sum += dist;
            min = Math.min(min, sum);
            return;
        }
        
        for (int i = st; i < c.size(); i++) {
            visited[i] = true;
            dfs(d + 1, r, i + 1);
            visited[i] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) h.add(new int[] {i, k});
                else if (a == 2) c.add(new int[] {i, k});
            }
        }
        
        for (int i = 1; i <= m; i++) 
            dfs(0, i, 0);
        System.out.print(min);
    }
}