import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        LinkedList<Integer> q = new LinkedList<>();
        int n = s.nextInt();
        for (int i = 0; i < n; i++)
            q.add(i + 1);
        
        while (q.size() != 1) {
            q.poll();
            q.add(q.poll());
        }
        System.out.print(q.getFirst());
    }
}