import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        LinkedList<Integer> d = new LinkedList<>();
        int n = s.nextInt();
        int m = s.nextInt();
        int[] arr = new int[m];
        for (int i = 1; i <= n; i++)
            d.add(i);
        for (int i = 0; i < m; i++)
            arr[i] = s.nextInt();
        
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            while (d.getFirst() != arr[i]) {
                cnt++;
                int index = d.indexOf(arr[i]);
                if (index < d.size() - index)
                    d.add(d.poll());
                else d.addFirst(d.pollLast());
            }
            d.pollFirst();
        }
        
        System.out.print(cnt);
    }
}