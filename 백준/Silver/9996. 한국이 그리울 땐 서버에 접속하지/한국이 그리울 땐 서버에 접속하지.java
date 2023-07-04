import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String p = s.nextLine();
        String[] arr = new String[2];
        for (int i = 0; i < p.length(); i++)
            if (p.charAt(i) == '*') {
                arr[0] = p.substring(0, i);
                arr[1] = p.substring(i + 1);
            }

        for (int i = 0; i < n; i++) {
            String str = s.nextLine();

            if ((arr[0] + arr[1]).equals(str))
                System.out.println("DA");
            else {
                if (arr[0].length() + arr[1].length() < str.length() && arr[0].equals(str.substring(0, arr[0].length())) && arr[1].equals(str.substring(str.length() - arr[1].length())))
                    System.out.println("DA");
                else System.out.println("NE");    
            }
        }
    }
}
