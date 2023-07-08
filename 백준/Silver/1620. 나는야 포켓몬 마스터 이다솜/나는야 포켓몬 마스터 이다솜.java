import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> m1 = new HashMap<>();
        Map<String, String> m2 = new HashMap<>();
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            m1.put(str, String.valueOf(i));
            m2.put(String.valueOf(i), str);
        }
        
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (m1.containsKey(str))
                System.out.println(m1.get(str));
            else System.out.println(m2.get(str));
        }
    }
}