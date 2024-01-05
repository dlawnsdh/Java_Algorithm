import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] str = s.nextLine().split(" ");
            if (str[1].equals("enter")) set.add(str[0]);
            else set.remove(str[0]);
        }
        
        List<String> l = new ArrayList<>(set);
        Collections.sort(l);
        for (int i = l.size() - 1; i >= 0; i--)
            System.out.println(l.get(i));
	}
}