import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int cnt = 0;

        for (String string : arr) {
            String tmp = str;
            String str2 = str.replaceAll(string, "");
            str = str.replaceAll(string, " ");
            if (!str.equals(tmp))
                cnt += str.length() - str2.length();
        }
        str = str.replaceAll(" ", "");
        System.out.println(cnt + str.length());
    }
}