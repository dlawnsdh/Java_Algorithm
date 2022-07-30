package algorithm;

import java.util.Scanner;
import java.util.*;

public class test {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String str = s.next();
		int a = str.charAt(0) - 97;
		int b = str.charAt(1) - 49;
		int cnt = 0;
		
		int[][] move = {{-1, -2}, {1, -2}, {-1, 2}, {1, 2}, {-2, -1}, {-2, 1}, {2, -1}, {2, 1}};
		
		for (int i = 0; i < move.length; i++) {
			int x = a + move[i][0];
			int y = b + move[i][1];
			if (x >= 0 && x <= 7 && y >= 0 && y <= 7)
				cnt++;
		}
		System.out.println(cnt);
	}
}
