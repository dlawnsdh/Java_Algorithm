/* 나중에 다시 풀어보기 */
package algorithm;

import java.util.*;

public class test {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(); int m = s.nextInt();
		int[] a = new int[n];
		int[] d = new int[m + 1];
		Arrays.fill(d, 10001);
		for (int i = 0; i < n; i++)
			a[i] = s.nextInt();
		
		d[0] = 0;
		for (int i = 0; i < n; i++)
			for (int j = a[i]; j <= m; j++) {
				if (d[j - a[i]] != 10001)
					d[j] = Math.min(d[j], d[j - a[i]] + 1);
			}
		if (d[m] == 10001)
			System.out.print(-1);
		else
			System.out.print(d[m]);
	}
}
