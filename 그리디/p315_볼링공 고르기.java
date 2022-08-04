package algorithm;

import java.util.*;

public class test {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(); int m = s.nextInt();
		int cnt = 0;
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = s.nextInt();
		
		for (int i = 0; i < n - 1; i++) 
			for (int k = i + 1; k < n; k++) 
				if (a[i] != a[k])
					cnt++;
				
		System.out.print(cnt);
	}
}
