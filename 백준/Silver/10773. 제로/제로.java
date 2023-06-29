import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        int n = s.nextInt();
        
        for (int i = 0; i < n; i++) {
            int k = s.nextInt();
            if (k == 0)
                st.pop();
            else st.push(k);
        }
        
        System.out.print(st.stream().mapToInt(Integer::intValue).sum());
    }
}