import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            Stack<Character> st = new Stack<>();
            String str = s.nextLine();
            if (str.length() % 2 == 0) {
                for (int k = 0; k < str.length(); k++) {
                    if (st.isEmpty())
                        st.push(str.charAt(k));
                    else if (st.peek() == str.charAt(k))
                        st.pop();
                    else st.push(str.charAt(k));
                }
                if (st.isEmpty())
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}