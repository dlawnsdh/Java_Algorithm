import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<int[]> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i + 1] = Integer.parseInt(str[i]);

        for (int i = 1; i < n + 1; i++) {
            if (s.isEmpty()) {
                System.out.print("0 ");
                s.push(new int[] {arr[i], i});
            } else {
                while (!s.isEmpty()) {
                    if (arr[i] >= s.peek()[0]) s.pop();
                    else {
                        System.out.print(s.peek()[1] + " ");
                        s.push(new int[] {arr[i], i});
                        break;
                    }
                }
                if (s.isEmpty()) {
                    System.out.print("0 ");
                    s.push(new int[] {arr[i], i});
                }
            }
        }
    }
}