import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;
            g.get(a).add(b);
            g.get(b).add(a);
        }
        
        int[][] arr = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            Queue<Integer> q = new LinkedList<>();
            int[] dist = new int[n + 1];
            Arrays.fill(dist, -1);
            
            dist[i] = 0;
            q.add(i);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int k = 0; k < g.get(cur).size(); k++) {
                    int nx = g.get(cur).get(k);
                    if (dist[nx] < 0) {
                        dist[nx] = dist[cur] + 1;
                        q.add(nx);
                    }
                }
            }
            
            Arrays.sort(dist);
            arr[i][0] = i;
            arr[i][1] = dist[n];
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        int score = arr[1][1];
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            if (arr[i][1] == score) {
                sb.append(arr[i][0]).append(' ');
                cnt++;
            }
        System.out.println(score + " " + cnt);
        System.out.print(sb);
    }
}