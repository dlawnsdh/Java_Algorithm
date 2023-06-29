import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        StringBuilder b = new StringBuilder();
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
 
        int index = 1;
        for (int i = 0; i < n; i++) {
            if (st.isEmpty() || index <= arr[i])
                for (; index <= arr[i]; index++) {
                    st.push(index);
                    b.append("+\n");
                }
            else
                if (st.peek() != arr[i])
                    break;
            st.pop();
            b.append("-\n");
        }
        
        if (st.isEmpty())
            System.out.print(b);
        else System.out.print("NO");
    }
}