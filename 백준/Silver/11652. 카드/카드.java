import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Map<Long, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long k = s.nextLong();
            if (!m.containsKey(k)) m.put(k, 1);
            else m.put(k, m.get(k) + 1);
        }
        
        int max = m.values().stream().max(Integer::compareTo).orElse(0);
        long num = m.keySet().stream().filter(k -> m.get(k) == max).min(Long::compareTo).orElse(0L);
        System.out.print(num);
    }
}