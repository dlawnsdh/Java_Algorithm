import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<String> l = new ArrayList<>();
        while (true) {
            String str = s.nextLine();
            if (str.equals(".")) break;
            l.add(str);
        }
        
        for (String str : l) {
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                switch (str.charAt(i)) {
                    case '(':
                        st.push('(');
                        break;
                    case ')':
                        if (!st.isEmpty() && st.peek() == '(')
                            st.pop();
                        else st.push(')');
                        break;
                    case '[':
                        st.push('[');
                        break;
                    case ']':
                        if (!st.isEmpty() && st.peek() == '[')
                            st.pop();
                        else st.push(']');
                        break;
                }
            }

            if (st.isEmpty())
                System.out.println("yes");
            else System.out.println("no");
        }
    }
}