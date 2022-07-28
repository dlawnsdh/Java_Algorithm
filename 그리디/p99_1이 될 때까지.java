package algorithm;

import java.util.Scanner;
import java.util.*;

public class test {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n, k, cnt = 0;
		n = s.nextInt(); k = s.nextInt(); 
		
		while (n != 1) {
			if (n % k != 0) {
				n--;
				cnt++;
			}
			else {
				n /= k;
				cnt++;
			}
		}
		
		System.out.println(cnt);	
	}
}
