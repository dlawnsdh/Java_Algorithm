import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < k; i++) {
            int n = s.nextInt();
            if (st.isEmpty() || n != 0)
                st.push(n);
            else st.pop();
        }
        System.out.print(st.stream().reduce(Integer::sum).orElse(0));
	}
}