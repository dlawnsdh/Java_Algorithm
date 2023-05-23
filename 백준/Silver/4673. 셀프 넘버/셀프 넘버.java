import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10001];

        for (int i = 1; i < arr.length; i++) {
            String str = Integer.toString(i);
            int sum = 0;
            for (int k = 0; k < str.length(); k++)
                sum += str.charAt(k) - 48;
            if (i + sum <= 10000)
                arr[i + sum]++;
        }
        
        for (int i = 1; i < arr.length; i++)
            if (arr[i] == 0)
                System.out.println(i);
    }
}