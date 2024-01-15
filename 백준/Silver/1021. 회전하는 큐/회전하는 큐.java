import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        LinkedList<Integer> l = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            l.add(i);
        
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();
            if (l.indexOf(k) < l.size() - l.indexOf(k)) {
                while (l.peek() != k) {
                    l.add(l.poll());
                    sum++;
                }
            } else {
                while (l.peek() != k) {
                    l.addFirst(l.removeLast());
                    sum++;
                }
            }
            l.poll();
        }
        System.out.print(sum);
    }
}