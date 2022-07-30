package algorithm;

import java.util.*;
import queue.LinkedQueue;

public class test {
	
	public static int[][] tool = new int[1000][1000];
	public static int n, m;
	public static boolean dfs(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		if (tool[x][y] == 0) {
			tool[x][y] = 1;
			dfs(x - 1, y);
			dfs(x + 1, y);
			dfs(x, y - 1);
			dfs(x, y + 1);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt(); m = s.nextInt();
		s.nextLine();
		for (int i = 0; i < n; i++) {
			String str = s.nextLine();
			for (int k = 0; k < m; k++)
				tool[i][k] = str.charAt(k) - '0';
		}
		
		int cnt = 0;
		for (int i = 0; i < n; i++)
			for (int k = 0; k < m; k++)
				if (dfs(i,  k) == true)
					cnt++;
		System.out.println(cnt);
	}
}
