import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.startsWith("push")) {
                s.push(Integer.parseInt(str.substring(5)));
            } else if (str.equals("pop")) {
                if (s.isEmpty()) System.out.println(-1);
                else System.out.println(s.pop());
            } else if (str.equals("size")) {
                System.out.println(s.size());
            } else if (str.equals("empty")) {
                if (s.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else {
                if (s.isEmpty()) System.out.println(-1);
                else System.out.println(s.peek());
            }
        }
    }
}