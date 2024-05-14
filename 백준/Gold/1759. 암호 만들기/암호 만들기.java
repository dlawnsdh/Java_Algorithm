import java.util.*;
import java.io.*;

public class Main {
    static char[] arr;
    static boolean[] visited;
    static Set<Character> set = new HashSet<>() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
    }};
    static StringBuilder sb = new StringBuilder();

    static boolean check(char[] str) {
        int n1 = 0;
        int n2 = 0;
        for (char c : str) {
            if (set.contains(c)) n1++;
            else n2++;
        }
        if (n1 < 1 || n2 < 2)
            return false;
        return true;
    }
    static void dfs(char[] result, int st, int d, int r) {
        if (d == r) {
            if (check(result)) {
                StringBuilder b = new StringBuilder();
                for (char c : result)
                    b.append(c);
                sb.append(b).append('\n');
            }
            return;
        }

        for (int i = st; i < arr.length; i++)
            if (!visited[i]) {
                visited[i] = true;
                result[d] = arr[i];
                dfs(result, i + 1, d + 1, r);
                visited[i] = false;
            }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        visited = new boolean[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++)
            arr[i] = st.nextToken().charAt(0);

        Arrays.sort(arr);
        dfs(new char[l], 0, 0, l);
        System.out.print(sb);
    }
}