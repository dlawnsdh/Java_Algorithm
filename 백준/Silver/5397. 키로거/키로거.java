import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            Stack<Character> l = new Stack<>();
            Stack<Character> r = new Stack<>();
            
            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) == '<') {
                    if (!l.isEmpty()) r.push(l.pop());
                } else if (s.charAt(k) == '>') {
                    if (!r.isEmpty()) l.push(r.pop());
                } else if (s.charAt(k) == '-') {
                    if (!l.isEmpty()) l.pop();
                } else l.push(s.charAt(k));
            }
            
            StringBuilder b = new StringBuilder();
            while (!l.isEmpty()) b.append(l.pop());
            b.reverse();
            while (!r.isEmpty()) b.append(r.pop());
            System.out.println(b);
        }
    }
}