import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        String str = br.readLine();
        for (int i = 0; i < n; i++)
            arr[i] = str.charAt(i) - 48;
        
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.isEmpty() || k == 0) s.push(arr[i]);
            else {
                while (k > 0 && !s.isEmpty() && s.peek() < arr[i]) {
                    k--;
                    s.pop();
                }
                s.push(arr[i]);
            }
        }
        StringBuilder b = new StringBuilder();
        while (k > 0) {
            s.pop();
            k--;
        }
        while (!s.isEmpty())
            b.append(s.pop());
        System.out.print(b.reverse());
    }
}