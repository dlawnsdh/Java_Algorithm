package algorithm;

import java.util.*;

public class test {
	
	public static boolean bs(int[] a, int target, int start, int end) {
		if (start > end)
			return false;
		int mid = (start + end) / 2;
		if (a[mid] == target)
			return true;
		else if (a[mid] > target)
			return bs(a, target, start, mid - 1);
		else
			return bs(a, target, mid + 1, end);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = s.nextInt();
		int m = s.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; i++)
			b[i] = s.nextInt();
		
		Arrays.sort(a);
		for (int i = 0; i < m; i++) {
			if (bs(a, b[i], 0, n - 1))
				System.out.print("yes ");
			else
				System.out.print("no ");
		}
	}
}
