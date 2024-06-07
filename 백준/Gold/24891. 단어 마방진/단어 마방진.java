import java.util.*;
import java.io.*;

public class Main {
    static String[] arr;
    static boolean[] visited;
    
    static void dfs(String[] result, int d, int r)  {
        if (d == r) {
            if (check(result)) {
                StringBuilder b = new StringBuilder();
                for (String s :  result)
                    b.append(s).append('\n');
                System.out.println(b);
                System.exit(0);
            }
            return;
        }
        
        for (int i = 0; i < arr.length; i++)
            if (!visited[i]) {
                visited[i] = true;
                result[d] = arr[i];
                dfs(result, d + 1, r);
                visited[i] = false;
            }
    }
    
    static boolean check(String[] str) {
        for (int i = 0; i < str.length; i++)
            for (int k = 0; k < str.length; k++)
                if (str[i].charAt(k) != str[k].charAt(i))
                    return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new String[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            arr[i] = br.readLine();
        
        Arrays.sort(arr);
        dfs(new String[l], 0, l);
        System.out.println("NONE");
    }
}