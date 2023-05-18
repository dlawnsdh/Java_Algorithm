import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            int k = s.nextInt();
            set.add(k % 42);
        }
        System.out.print(set.size());
    }
}