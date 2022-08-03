package algorithm;

import java.util.*;

public class test {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int cnt = 0, k = n;
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = s.nextInt();
		
		Arrays.sort(a);
		while (k != 0) {
			k -= a[k - 1];
			cnt++;
		}
		System.out.print(cnt);
	}
}
