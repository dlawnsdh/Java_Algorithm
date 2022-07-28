package algorithm;

import java.util.Scanner;
import java.util.*;

public class test {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int cnt = 0;
		
		for (int i = 0; i <= n; i++)
			for (int j = 0; j < 60; j++)
				for (int k = 0; k < 60; k++) {
					String str = Integer.toString(i) + Integer.toString(j) + Integer.toString(k);
					for (int g = 0; g < str.length(); g++)
						if (str.charAt(g) == '3') {
							cnt++;
							break;
						}
				}
		System.out.println(cnt);
	}
}
