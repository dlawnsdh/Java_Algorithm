import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            if (s.equals(".")) break;
            else {
                Stack<Character> st = new Stack<>();
                for (int i = 0; i < s.length(); i++) {
                    switch (s.charAt(i)) {
                        case '(': st.push('(');
                            break;
                        case '[': st.push('[');
                            break;
                        case ')':
                            if (!st.isEmpty() && st.peek() == '(')
                                st.pop();
                            else st.push(')');
                            break;
                        case ']':
                            if (!st.isEmpty() && st.peek() == '[')
                                st.pop();
                            else st.push(']');
                            break;
                    }
                }
                if (st.isEmpty()) System.out.println("yes");
                else System.out.println("no");
            }
        }
    }
}