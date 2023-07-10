import java.io.*;
import java.util.*;

public class Main {
    public static int kkk(String str) {
        Stack<Character> s = new Stack<>();
        int sum = 0;
        int tmp = 1;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                s.push('(');
                tmp *= 2;
            }
            else if (c == '[') {
                s.push('[');
                tmp *= 3;
            }
            else if (c == ')') {
                if (s.isEmpty() || s.peek() != '(') return 0;
                if (str.charAt(i - 1) == '(')
                    sum += tmp;
                s.pop();
                tmp /= 2;
            }
            else {
                if (s.isEmpty() || s.peek() != '[') return 0;
                if (str.charAt(i - 1) == '[')
                    sum += tmp;
                s.pop();
                tmp /= 3;
            }
        }
    
        if (!s.isEmpty())
            return 0;
        return sum;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        System.out.print(kkk(str));
    }
}
