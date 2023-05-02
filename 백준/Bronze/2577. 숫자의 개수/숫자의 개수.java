import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = new int[10];
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        String str = Integer.toString(a * b * c);
        for (int i = 0; i < str.length(); i++)
            arr[str.charAt(i) - 48]++;
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
        }
}