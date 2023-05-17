import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        int t = Integer.parseInt(s.nextLine());

        for (int i = 0; i < t; i++) {
            int score = 0;
            String str = s.nextLine();
            for (int k = 0; k < str.length(); k++) {
                if (str.charAt(k) == 'O') {
                    stack.push('O');
                    score += stack.size();
                }
                else stack.clear();
            }
            stack.clear();

            System.out.println(score);
        }
    }
}