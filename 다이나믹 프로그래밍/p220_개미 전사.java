package algorithm;

import java.util.*;

public class test {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int[] d = new int[101];
		for (int i = 1; i <= n; i ++)
			d[i] = s.nextInt();
		
		for (int i = 3; i <= n; i++) {
			d[i] = Math.max(d[i - 1], d[i - 2] + d[i]);
		}
		System.out.print(d[n]);
	}
}
