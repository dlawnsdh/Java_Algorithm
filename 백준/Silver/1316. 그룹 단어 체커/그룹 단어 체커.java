import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            String str = s.nextLine();
            Set<Character> set = new HashSet<>();
            Stack<Character> stack = new Stack<>();
            int cnt = 0;

            for (int k = 0; k < str.length(); k++) {
                char c = str.charAt(k);
                set.add(c);
                if (stack.isEmpty() || stack.peek() == c)
                    stack.push(c);
                else {
                    cnt++;
                    stack.clear();
                    stack.push(c);
                }
            }

            if (!stack.isEmpty())
                cnt++;
            if (cnt == set.size())
                count++;
        }
        System.out.print(count);
    }
}