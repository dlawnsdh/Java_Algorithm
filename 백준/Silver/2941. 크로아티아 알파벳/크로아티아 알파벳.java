import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        
        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for (String o : arr)
            str = str.replaceAll(o, "@");
        System.out.print(str.length());
	}
}