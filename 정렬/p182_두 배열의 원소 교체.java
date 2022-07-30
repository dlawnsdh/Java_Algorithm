package algorithm;

import java.util.*;

public class test {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(); int k = s.nextInt();
		Integer[] a = new Integer[n];
		Integer[] b = new Integer[n];
		
		for (int i = 0; i < n; i++) 
			a[i] = s.nextInt();
		for (int i = 0; i < n; i++) 
			b[i] = s.nextInt();
		
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());
		
		for (int i = 0; i < k; i++) {
			if (a[i] < b[i]) {
				int tmp = a[i];
				a[i] = b[i];
				b[i] = tmp;
			}
			else
				break;
		}
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += a[i];
		System.out.println(sum);
	}
}
