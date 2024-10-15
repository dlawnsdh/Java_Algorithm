import java.util.*;
import java.io.*;

public class Main {
    static boolean check(int n) {
        return 0 <= n && n <= 100000;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        
        int min = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {n, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]] = true;
            if (cur[0] == k)
                min = Math.min(min, cur[1]);
            if (check(cur[0] + 1) && !visited[cur[0] + 1]) {
                q.add(new int[] {cur[0] + 1, cur[1] + 1});
            }
            if (check(cur[0] - 1) && !visited[cur[0] - 1]) {
                q.add(new int[] {cur[0] - 1, cur[1] + 1});
            }
            if (check(cur[0] * 2) && !visited[cur[0] * 2]) {
                q.add(new int[] {cur[0] * 2, cur[1]});
            }
        }
        System.out.print(min);
    }
}