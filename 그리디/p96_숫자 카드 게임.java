package algorithm;

import java.util.Scanner;
import java.util.*;

public class test {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n, m, result = 0;
		n = s.nextInt(); m = s.nextInt(); 
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			int min = 10001;
			for (int k = 0; k < m; k++) {
				int x = s.nextInt();
				min = Math.min(min, x);
			}
			result = Math.max(result, min);
		}
		
		System.out.println(result);	
	}
}
