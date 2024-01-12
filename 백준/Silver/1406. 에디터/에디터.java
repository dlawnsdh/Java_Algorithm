import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> l = new Stack<>();
        Stack<Character> r = new Stack<>();
        String s = br.readLine();
        int n  = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < s.length(); i++)
            l.push(s.charAt(i));
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.equals("L")) {
                if (!l.isEmpty()) r.push(l.pop());
            } else if (str.equals("D")) {
                if (!r.isEmpty()) l.push(r.pop());
            } else if (str.equals("B")) {
                if (!l.isEmpty()) l.pop();
            } else l.push(str.charAt(2));
        }
        
        StringBuilder b = new StringBuilder();
        while(!l.isEmpty()) b.append(l.pop());
        b.reverse();
        while(!r.isEmpty()) b.append(r.pop());
        System.out.print(b);
    }
}