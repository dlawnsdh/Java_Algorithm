package algorithm;

import java.util.*;

public class test {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int[] d = new int[1000];
		
		d[0] = 1;
		d[1] = 3;
		for (int i = 2; i < n; i++) {
			d[i] = d[i - 1] + 2 * d[i - 2];
		}
		System.out.print(d[n - 1] % 796796);
	}
}
