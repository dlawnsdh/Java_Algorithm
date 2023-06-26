import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map<Integer, Integer[]> m = new HashMap<>();
        int n = s.nextInt();
        int k = s.nextInt();
        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            Integer[] tmp = {0, 0};

            if (m.containsKey(y))
                tmp = m.get(y);
            tmp[x]++;
            m.put(y, tmp);
        }
        
        int room = 0;
        for (Integer[] arr : m.values()) 
            room += arr[0] / k + arr[0] % k + arr[1] / k + arr[1] % k;
        
        System.out.print(room);
    }
}