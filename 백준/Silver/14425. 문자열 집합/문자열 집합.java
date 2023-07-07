import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> s = new HashSet<>();
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        
        for (int i = 0; i < n; i++) 
            s.add(br.readLine());
        
        int cnt = 0;
        for (int i = 0; i < m; i++) 
            if (s.contains(br.readLine()))
                cnt++;
        System.out.print(cnt);
    }
}