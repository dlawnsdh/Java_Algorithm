import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> s = new Stack<>();
        Stack<Integer> idx = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        StringBuilder b = new StringBuilder("0 ");
        String[] arr = br.readLine().split(" ");
        s.push(Integer.parseInt(arr[0]));
        idx.push(1);
        for (int i = 1; i < n; i++) {
            int k = Integer.parseInt(arr[i]);
            while (!s.isEmpty() && s.peek() < k) {
                s.pop();
                idx.pop();
            }
            if (s.isEmpty()) b.append("0 ");
            else b.append(idx.peek()).append(" ");
            s.push(k);
            idx.push(i + 1);
        }

        bw.write(String.valueOf(b));
        bw.flush();
    }
}