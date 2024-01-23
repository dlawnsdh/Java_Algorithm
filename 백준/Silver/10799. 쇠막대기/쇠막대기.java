import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> s = new Stack<>();
        
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                if (str.charAt(i - 1) == '(') {
                    s.pop();
                    sum += s.size();
                } else {
                    sum++;
                    s.pop();
                }
            } else s.push(str.charAt(i));
        }
        
        System.out.print(sum);
    }
}