import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder b = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Stack<Character> l = new Stack<>();
            Stack<Character> r = new Stack<>();
            String str = br.readLine(); 

            for (int k = 0; k < str.length(); k++)
                switch (str.charAt(k)) {
                    case '<':
                        if (!l.isEmpty())
                            r.push(l.pop());
                        break;
                    case '>':
                        if (!r.isEmpty())
                            l.push(r.pop());
                        break;
                    case '-':
                        if (!l.isEmpty())
                            l.pop();
                        break;
                    default:
                        l.push(str.charAt(k));
                        break;
                }

            while(!l.isEmpty())
			    r.push(l.pop());
		    while(!r.isEmpty())
			    b.append(r.pop());
            b.append("\n");
        }
        System.out.println(b.toString());
    }
}