package algorithm;

import java.util.Scanner;
import java.util.*;

public class test {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int x = 1, y = 1;
		s.nextLine();
		String[] str = s.nextLine().split(" ");

		for (int i = 0; i < str.length; i++) {
			switch (str[i]) {
			case "L":
				if (x >= 1 && x <= n && y > 1 && y <= n)
					y--;
				break;
			case "R":
				if (x >= 1 && x <= n && y >= 1 && y < n)
					y++;
				break;
			case "U":
				if (x > 1 && x <= n && y >= 1 && y <= n)
					x--;
				break;
			case "D":
				if (x >= 1 && x < n && y >= 1 && y <= n)
					x++;
				break;
			}
		}
		System.out.printf("%d %d", x, y);
	}
}
