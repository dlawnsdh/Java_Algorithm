import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        
        for (int i = 0; i < t; i++) {
            String str = s.nextLine();
            int r = str.charAt(0) - 48;
            String a = str.substring(2);
            StringBuilder b = new StringBuilder();

            for (int j = 0; j < a.length(); j++)
                b.append(Character.toString(a.charAt(j)).repeat(r));
            System.out.println(b);
        }
    }
}