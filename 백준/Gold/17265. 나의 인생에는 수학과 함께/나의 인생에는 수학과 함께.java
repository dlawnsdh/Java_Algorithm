import java.util.*;
import java.io.*;

public class Main {
    static String[][] map;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    static void dfs (String s, int x, int y, int n) {
        if (x == n - 1 && y == n - 1) {
            int result = calculate(s + map[n - 1][n - 1]);
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
        
        int[] dx = {1, 0};
        int[] dy = {0, 1};
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= n || ny >= n) continue;
            dfs(s + map[x][y], nx, ny, n);
        }
    }
    
    static int calculate(String str) {
        Stack<Integer> s = new Stack<>();
        s.push(str.charAt(0) - 48);
        for (int i = 1; i < str.length() - 1; i += 2) {
            if (str.charAt(i) == '+'){
                s.push(s.pop() + (str.charAt(i + 1) - 48));
            } else if (str.charAt(i) == '-'){
                s.push(s.pop() - (str.charAt(i + 1) - 48));
            } else s.push(s.pop() * (str.charAt(i + 1) - 48));
        }
        return s.pop();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        map = new String[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++)
                map[i][k] = st.nextToken();
        }
        
        dfs("", 0, 0, n);
        System.out.print(max + " " + min);
    }
}