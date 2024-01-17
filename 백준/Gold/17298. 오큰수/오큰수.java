import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        Stack<Integer> idx = new Stack<>();
        String[] arr = br.readLine().split(" ");
        int[] result = new int[n];
        Arrays.fill(result, -1);
       
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(arr[i]);
            while (!s.isEmpty() && s.peek() < k) {
                result[idx.pop()] = k;
                s.pop();
            }
            s.push(k);
            idx.push(i);
        }
        for (int i : result)
            bw.write(i + " ");
        bw.flush();
    }
}