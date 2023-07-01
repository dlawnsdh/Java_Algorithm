import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.nextLine();
        String str2 = s.nextLine();
        
        str1 = str1.replaceAll(str2, "@");
        
        int cnt = 0;
        for (int i = 0; i < str1.length(); i++)
            if (str1.charAt(i) == '@')
                cnt++;
        System.out.print(cnt);
    }
}