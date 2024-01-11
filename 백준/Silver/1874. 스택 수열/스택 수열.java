import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        int n = sc.nextInt();
        
        int cur = 1;
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            if (s.isEmpty() || s.peek() < k) {
                for (; cur <= k; cur++) {
                    s.push(cur);
                    b.append("+\n");
                }
                s.pop();
                b.append("-\n");
            } else if (s.peek() == k) {
                s.pop();
                b.append("-\n");
            }
        }
        
        if (s.isEmpty()) System.out.print(b);
        else System.out.print("NO");
    }
} 