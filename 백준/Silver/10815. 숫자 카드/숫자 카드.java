import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; i++)
            set.add(s.nextInt());
        int m = s.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++)
            arr[i] = s.nextInt();
        
        for (int i = 0; i < m; i++) {
            if (set.contains(arr[i]))
                System.out.print(1 + " ");
            else
                System.out.print(0 + " ");
        }
    }
}