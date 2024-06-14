import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        StringBuilder b = new StringBuilder();
        Stack<int[]> s = new Stack<>();
        for (int i = 1; i <= n; i++) {
            if (s.isEmpty()) {
                s.push(new int[] {arr[i], i});
                b.append(0).append(' ');
            } else {
                while (!s.isEmpty() && s.peek()[0] < arr[i])
                    s.pop();
                if (s.isEmpty()) b.append(0).append(' ');
                else b.append(s.peek()[1]).append(' ');
                s.push(new int[] {arr[i], i});
            }
        }
        System.out.print(b);
    }
}