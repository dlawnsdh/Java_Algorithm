import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            Stack<Character> st = new Stack<>();
            String s = sc.nextLine();
            
            for (int k = 0; k < s.length(); k++) {
                if (!st.isEmpty() && st.peek() == s.charAt(k)) st.pop();
                else st.push(s.charAt(k));
            }
            
            if (st.isEmpty()) cnt++; 
        }
        System.out.print(cnt);
    }
}