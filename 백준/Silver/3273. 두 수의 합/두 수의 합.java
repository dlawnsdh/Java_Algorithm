import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        int x = s.nextInt();
       
        int cnt = 0;
        for (int i = 0; i < arr.length - 1; i++)
            for (int k = i + 1; k < arr.length; k++)
                if (arr[i] + arr[k] == x) {
                    cnt++;
                    break;
                }
        System.out.print(cnt);
    }
}