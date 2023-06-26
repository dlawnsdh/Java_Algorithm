import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] arr1 = s.nextLine().split("");
        String[] arr2 = s.nextLine().split("");
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        
        Arrays.stream(arr1).forEach(str -> {
            if (!m1.containsKey(str))
                m1.put(str, 1);
            else m1.put(str, m1.get(str) + 1);
        });
        Arrays.stream(arr2).forEach(str -> {
            if (!m2.containsKey(str))
                m2.put(str, 1);
            else m2.put(str, m2.get(str) + 1);
        });
        
        int cnt = 0;
        for (String k : m1.keySet()) {
            if (m2.containsKey(k)) 
                cnt += Math.abs(m1.get(k) - m2.get(k));
            else cnt += m1.get(k);
        }
        for (String k : m2.keySet()) 
            if (!m1.containsKey(k))
                cnt += m2.get(k);
        System.out.print(cnt);
    }
}