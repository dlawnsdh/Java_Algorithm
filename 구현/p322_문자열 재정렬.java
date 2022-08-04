package algorithm;

import java.util.*;

public class test {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		String string = "";
		int sum = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 48 && str.charAt(i) <= 57)
				sum += str.charAt(i) - '0';
			else
				string += str.charAt(i);
		}
	
		char[] a = new char[string.length()];
		for (int i = 0; i < string.length(); i++)
			a[i] = string.charAt(i);
		
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);
		System.out.print(sum);
	}
}
