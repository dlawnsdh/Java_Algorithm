import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int k = 0; k < s1.length(); k++)
            arr1[s1.charAt(k) - 97]++;
        for (int k = 0; k < s2.length(); k++)
            arr2[s2.charAt(k) - 97]++;
        
        int sum = 0;
        for (int k = 0; k < arr1.length; k++)
            sum += Math.abs(arr1[k] - arr2[k]);
        System.out.print(sum);
    }
}