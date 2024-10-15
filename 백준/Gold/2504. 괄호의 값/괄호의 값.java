import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Character> st = new Stack<>();
        
        int total = 0;
        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                st.push(arr[i]);
                num *= 2;
            } else if (arr[i] == '[') {
                st.push(arr[i]);
                num *= 3;
            } else if (arr[i] == ')') {
                if (st.isEmpty() || st.peek() != '(') {
                    total = 0;
                    break;
                } else if (arr[i - 1] == '(')
                    total += num;
                st.pop();
                num /= 2;
            } else {
                if (st.isEmpty() || st.peek() != '[') {
                    total = 0;
                    break;
                } else if (arr[i - 1] == '[')
                    total += num;
                st.pop();
                num /= 3;
            }
        }
        if (!st.isEmpty()) System.out.print(0);
        else System.out.print(total);
    }
}