import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int k = str.length() / 10;
        int r = str.length() % 10;

        if (k == 0)
            System.out.println(str);
        else {
            int index = 0;
            for (int i = 0; i < k; i++) {
                System.out.println(str.substring(index, index + 10));
                index += 10;
            }
            if (r != 0)
                System.out.println(str.substring(index));
        }
    }
}