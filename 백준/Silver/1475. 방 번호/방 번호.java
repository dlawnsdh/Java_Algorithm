import java.util.*;

public class Main {
    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int[] arr = new int[10];
        for (int i = 0; i < str.length(); i++)
            arr[str.charAt(i) - 48]++;
        
        int max = 0;
        for (int i = 0; i < arr.length; i++) 
            if (i != 6 && i != 9)
                max = Math.max(max, arr[i]);
        int k = (arr[6] + arr[9]) / 2 + (arr[6] + arr[9]) % 2;
        System.out.print(Math.max(k, max));
    }
}