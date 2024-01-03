import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10001];

        for (int i = 1; i < 10001; i++) {
            String str = Integer.toString(i);
            int sum = i;
            for (int k = 0; k < str.length(); k++)
                sum += str.charAt(k) - 48;
            if (sum < 10001)
                arr[sum]++;
        }

        for (int i = 1; i < 10001; i++)
            if (arr[i] == 0)
                System.out.println(i);
    }
}