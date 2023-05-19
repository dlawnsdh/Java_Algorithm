import java.util.*;

public class Main {
     public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        if (str.equals(" "))
            System.out.print(0);
        else {
            String[] arr = str.trim().split(" ");
            System.out.print(arr.length);
        }
     }
}