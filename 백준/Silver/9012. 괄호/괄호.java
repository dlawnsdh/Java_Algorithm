import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            Stack<Character> st = new Stack<>();
            String s = br.readLine();
            
            for (int k = 0; k < s.length(); k++) {
                char c = s.charAt(k);
                if (!st.isEmpty() && ((st.peek() == '(' && c == ')') || (st.peek() == '[' && c == ']')))
                    st.pop();
                else st.push(c);
            }
            if (st.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}