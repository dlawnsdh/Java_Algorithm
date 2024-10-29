import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    static List<List<Integer>> g = new ArrayList<>();
    static int[] num;
    static StringBuilder sb = new StringBuilder();
    static int div = 1000000007;
    
    static void dfs(boolean[] visited, int x, int e, String str) {
        visited[x] = true;
        if (x == e) {
            BigInteger b = new BigInteger(str);
            String sum = b.remainder(new BigInteger(String.valueOf(div))).toString();
            sb.append(sum).append('\n');
        } else {
            for (int i = 0; i < g.get(x).size(); i++) {
                int nx = g.get(x).get(i);
                if (!visited[nx])
                    dfs(visited, nx, e, str + num[nx] % div);
            }
        }
    } 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        num = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            num[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g.get(a).add(b);
            g.get(b).add(a);
        }
        
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            dfs(new boolean[n + 1], s, e, Integer.toString(num[s]));
        }
        System.out.print(sb);
    }
}