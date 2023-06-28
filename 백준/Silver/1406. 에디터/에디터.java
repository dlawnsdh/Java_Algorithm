import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	String str = br.readLine();
	int n = Integer.parseInt(br.readLine());

	Stack<Character> l = new Stack<>();
        Stack<Character> r = new Stack<>();
        for (int i = 0; i < str.length(); i++)
            l.push(str.charAt(i));
		
	for(int i = 0; i < n; i++) {
	    String o = br.readLine();
	    char c = o.charAt(0);
			
	    switch(c) {
		case 'L':
		    if (!l.isEmpty())
                    	r.push(l.pop());
                    break;
		case 'D':
		    if(!r.isEmpty())
			l.push(r.pop());
		    break;
		case 'B':
		    if(!l.isEmpty()) 
			l.pop();
		    break;
	       	case 'P':
		    l.push(o.charAt(2));
		    break;
	    }
	}
        
	while(!l.isEmpty())
	    r.push(l.pop());
	while(!r.isEmpty())
	    bw.write(r.pop());
		
	bw.flush();
	bw.close(); 
    }
}
