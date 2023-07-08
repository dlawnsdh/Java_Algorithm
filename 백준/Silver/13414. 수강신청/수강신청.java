import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<String> s = new LinkedHashSet<>();
        String[] arr = br.readLine().split(" ");
        int k = Integer.parseInt(arr[0]);
        int l = Integer.parseInt(arr[1]);
        
        for (int i = 0; i < l; i++) {
            String str = br.readLine();
            if (!s.contains(str))
                s.add(str);
            else {
                s.remove(str);
                s.add(str);
            }
        }
        
        int cnt = 0;
        for (String str : s) {
            System.out.println(str);
            cnt++;
            if (cnt == k) break;
        }
    }
}
