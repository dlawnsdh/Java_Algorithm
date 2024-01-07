import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(s.nextInt());
        
        int k = s.nextInt();
        for (int i = 0; i < k; i++) {
            if (set.contains(s.nextInt()))
                System.out.println(1);
            else System.out.println(0);
        }
    }
}