import java.util.Scanner;
public class Main {
    static int div(int n) {
        int[] arr = new int[n + 1];
        for (int i = 2; i <= n ; i++) {
            arr[i] = arr[i - 1] + 1; // 1을 뺀 경우
            if (i % 2 == 0)
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            if (i % 3 == 0)
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
        }
        return arr[n];
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(div(n));
    }
}