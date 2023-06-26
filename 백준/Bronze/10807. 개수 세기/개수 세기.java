import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int k = s.nextInt();
            if (!m.containsKey(k))
                m.put(k, 1);
            else m.put(k, m.get(k) + 1);
        }
        
        int v = s.nextInt();
        if (m.containsKey(v))
            System.out.print(m.get(v));
        else System.out.print(0);
    }
}