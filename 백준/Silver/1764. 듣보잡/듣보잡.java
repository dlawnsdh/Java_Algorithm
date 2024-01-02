import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] arr = s.nextLine().split(" ");
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        
        for (int i = 0; i < Integer.parseInt(arr[0]); i++)
            s1.add(s.nextLine());
        for (int i = 0; i < Integer.parseInt(arr[1]); i++)
            s2.add(s.nextLine());    
            
        List<String> result = s1.stream().filter(s2::contains).sorted().collect(Collectors.toList());
        System.out.println(result.size());
        result.forEach(System.out::println);
    }
}