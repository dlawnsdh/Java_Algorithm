import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        
        for (int i = 0; i < t; i++) {
            String str = s.nextLine();
            Stack<Character> st = new Stack<>();
            
            for (int k = 0; k < str.length(); k++) {
                if (str.charAt(k) == '(')
                    st.push('(');
                else {
                    if (st.isEmpty())
                        st.push(')');
                    else if (st.peek() == '(')
                        st.pop();
                }
            }
            
            if (st.isEmpty())
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}