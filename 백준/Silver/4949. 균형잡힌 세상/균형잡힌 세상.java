import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s.equals(".")) break;
            else {
                Stack<Character> st = new Stack<>();
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c == '(' || c == '[') st.push(c);
                    else if (c == ')' || c == ']') {
                        if (!st.isEmpty() && ((st.peek() == '(' && c == ')') || (st.peek() == '[' && c == ']')))
                            st.pop();
                        else st.push(c);
                    }
                }
                if (st.isEmpty()) System.out.println("yes");
                else System.out.println("no");
            }
        }
    }
}