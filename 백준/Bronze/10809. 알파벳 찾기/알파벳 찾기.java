import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for (int i = 0; i < str.length(); i++) {
            int k = str.charAt(i) - 97;
            if (arr[k] == -1)
                arr[k] = i;
        }
        for (int j : arr) System.out.print(j + " ");
    }
}