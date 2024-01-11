import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            int[] arr1 = new int[26];
            int[] arr2 = new int[26];
            
            for (int k = 0; k < s[0].length(); k++)
                arr1[s[0].charAt(k) - 97]++;
            for (int k = 0; k < s[1].length(); k++)
                arr2[s[1].charAt(k) - 97]++;
            
            boolean b = true;
            for (int k = 0; k < arr1.length; k++)
                if (arr1[k] != arr2[k]) {
                    b = false;
                    break;
                }
            if (b) System.out.println("Possible");
            else System.out.println("Impossible");
        }
    }
}