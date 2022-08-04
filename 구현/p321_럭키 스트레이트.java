package algorithm;

import java.util.*;

public class test {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		int left = 0, right = 0, mid = str.length() / 2;
		for (int i = 0; i < mid; i++) 
			left += str.charAt(i) - '0';
		
		for (int i = mid; i < str.length(); i++) 
			right += str.charAt(i) - '0';
		
		if (left == right)
			System.out.print("LUCKY");
		else
			System.out.print("READY");
	}
}
