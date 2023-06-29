import java.util.*;
import java.io.*;

public class Main {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         Stack<Integer> s = new Stack<>();
         int n = Integer.parseInt(br.readLine());
         
         for (int i = 0; i < n; i++) {
             String[] str = br.readLine().split(" ");
             switch (str[0]) {
                 case "push":
                     s.push(Integer.parseInt(str[1]));
                     break;
                 case "pop":
                     if (!s.isEmpty())
                         System.out.println(s.pop());
                     else System.out.println(-1);
                     break;
                 case "size":
                     System.out.println(s.size());
                     break;
                 case "empty":
                     if (s.isEmpty())
                         System.out.println(1);
                     else System.out.println(0);
                     break;
                 case "top":
                     if (!s.isEmpty())
                         System.out.println(s.peek());
                     else System.out.println(-1);
                     break;
             }
         }
     }
}