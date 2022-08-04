package algorithm;

import java.util.*;

public class test {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		int cnt0 = 0, cnt1 = 0;
		
		if (str.charAt(0) == '1')
			cnt0++;
		else
			cnt1++;
		
		for (int i = 0; i < str.length() - 1; i++) 
			if (str.charAt(i) != str.charAt(i + 1)) {
				if (str.charAt(i + 1) == '0')
					cnt1++;
				else
					cnt0++;
			}
		System.out.print(Math.min(cnt0, cnt1));
	}
}
