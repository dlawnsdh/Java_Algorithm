import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(s.nextInt());
        int x = s.nextInt();
        
        System.out.print(set.stream().filter(i -> set.contains(x - i)).count() / 2);
	}
}