import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = new int[26];
        String str = s.nextLine();
        
        for (int i = 0; i < str.length(); i++)
            arr[str.charAt(i) - 97]++;
        
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }
}