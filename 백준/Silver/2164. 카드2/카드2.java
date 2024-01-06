import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            q.add(i);
        for (int i = 0; i < n - 1; i++) {
            q.poll();
            q.add(q.poll());
        }
        System.out.print(q.peek());
	}
}