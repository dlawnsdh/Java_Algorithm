package algorithm;

import java.util.Scanner;
import java.util.*;

public class test {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n, m, k;
		n = s.nextInt(); m = s.nextInt(); k = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = s.nextInt();
		
		Arrays.sort(arr);
		int max = arr[n - 1];
		int smax = arr[n - 2];
		int result = (m / (k + 1)) * (k * max + smax) + (m % (k + 1) * max);
		
		System.out.println(result);	
	}
} 
