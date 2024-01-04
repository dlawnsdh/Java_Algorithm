import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        
        Stack<Integer> st = new Stack<>();
        int zero = 0;
        int one = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (st.isEmpty() || st.peek().equals(str.charAt(i) - 48))
                st.push(str.charAt(i) - 48);
            else {
                if (st.peek() == 0) zero++;
                else one++;
                st.clear();
                st.push(str.charAt(i) - 48);
            }
        }
        if (!st.isEmpty()) {
            if (st.peek() == 0) zero++;
            else one++;    
        }
        System.out.print(Math.min(zero, one)); 
	}
}