import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        
        String str = Integer.toString(a * b * c);
        int[] arr = new int[10];
        for (int i = 0; i < str.length(); i++)
            arr[str.charAt(i) - 48]++;
        
        Arrays.stream(arr).forEach(System.out::println);
    }
}
