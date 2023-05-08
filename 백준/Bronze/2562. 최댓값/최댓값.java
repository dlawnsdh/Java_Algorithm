import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = new int[9];
        int max = 0;
        int n = 0;
        for (int i = 0; i < 9; i++)
            arr[i] = s.nextInt();
        
        for (int i = 0; i < 9; i++)
            if (arr[i] > max) {
                max = arr[i];
                n = i;
            }
        System.out.printf("%d\n%d", max, n + 1);
    }
}