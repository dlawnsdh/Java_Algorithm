package algorithm;

import java.util.*;

public class test {
	
	public static int sum = 0, n, m;
	public static int bs(int[] a, int start, int end) {
		int large = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			for (int i = 0; i < a.length; i++)
				if (a[i] > mid)
					sum += (a[i] - mid); 
			if (sum >= m && large < mid) {
				large = mid;
				start = mid + 1;
			}
			if (sum < m)
				end = mid - 1;
			sum = 0; 
		}
		return large;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt(); m = s.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = s.nextInt();
		
		Arrays.sort(a);
		System.out.print(bs(a, 0, a[n - 1]));
	}
}
