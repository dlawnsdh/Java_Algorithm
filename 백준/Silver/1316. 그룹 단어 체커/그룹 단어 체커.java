import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            int[] arr = new int[26];
            String str = s.nextLine();

            arr[str.charAt(0) - 97]++;
            for (int k = 1; k < str.length(); k++) {
                int t = str.charAt(k) - 97;
                if (str.charAt(k - 1) == str.charAt(k) || (str.charAt(k - 1) != str.charAt(k) && arr[t] == 0))
                    arr[t]++;
            }

            if (Arrays.stream(arr).sum() == str.length())
                cnt++;
        }
        System.out.println(cnt);
	}
}