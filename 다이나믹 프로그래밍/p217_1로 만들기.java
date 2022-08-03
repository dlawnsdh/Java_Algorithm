package algorithm;

import java.util.*;

public class test {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int[] a = new int[30001];
		for (int i = 2; i < n + 1; i++) {
			a[i] = a[i - 1] + 1;
			if (i % 5 == 0) 
				a[i] = Math.min(a[i], a[i / 5] + 1);
			if (i % 3 == 0) 
				a[i] = Math.min(a[i], a[i / 3] + 1);
			if (i % 2 == 0) 
				a[i] = Math.min(a[i], a[i / 2] + 1);
		}
		System.out.print(a[n]);
	}
}
