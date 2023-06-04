import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] arr = new String[2];
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            arr = s.nextLine().split(" ");
            if (!set.contains(arr[0]))
                set.add(arr[0]);
            else set.remove(arr[0]);
        }
        
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        
        for (int i = list.size() - 1; i > -1; i--)
            System.out.println(list.get(i));
    } 
}