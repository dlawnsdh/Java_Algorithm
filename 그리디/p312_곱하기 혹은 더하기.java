package algorithm;

import java.util.*;

public class test {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String[] str = s.nextLine().split("");
		int[] a = new int[str.length];
		
		for (int i = 0; i < str.length; i++)
			a[i] = Integer.parseInt(str[i]);
		
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] <= 1 || a[i + 1] <= 1)
				a[i + 1] += a[i];
			else
				a[i + 1] *= a[i];
		}
		System.out.print(a[a.length - 1]);
	}
}
