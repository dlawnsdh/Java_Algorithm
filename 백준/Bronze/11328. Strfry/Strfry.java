import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        for (int i = 0; i < n; i++) {
            String[] arr = s.nextLine().split(" ");
            
            if (arr[0].length() != arr[1].length())
                System.out.println("Impossible");
            else {
                if (func(arr[0], arr[1]))
                    System.out.println("Possible");
                else System.out.println("Impossible");
            }  
        } 
    }
    
    public static boolean func(String s1, String s2) {
        String[] arr1 = s1.split("");
        String[] arr2 = s2.split("");
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        for (int i = 0; i < arr1.length; i++) 
            if (!arr1[i].equals(arr2[i]))
                return false;
        return true;
    }
}