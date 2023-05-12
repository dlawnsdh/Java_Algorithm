import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        int w = s.nextInt();
        int h = s.nextInt();
        int[] arr = new int[4];

        arr[0] = x;
        arr[1] = y;
        arr[2] = w - x;
        arr[3] = h - y;
        Arrays.sort(arr);
        System.out.print(arr[0]);
    }
}