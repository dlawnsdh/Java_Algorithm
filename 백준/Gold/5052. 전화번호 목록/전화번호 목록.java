import java.util.*;
import java.io.*;

public class Main {
    static String check(String[] number) {
        Set<String> s = new HashSet<>();
        for (int i = 0; i < number.length; i++) {
            for (int k = 1; k <= number[i].length(); k++)
                if (s.contains(number[i].substring(0, k)))
                    return "NO";
            s.add(number[i]);
        }
        return "YES";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            String[] number = new String[n];
            for (int i = 0; i < n; i++)
                number[i] = br.readLine();
            Arrays.sort(number);
            
            sb.append(check(number)).append('\n');
        }
        System.out.print(sb);
    }
}