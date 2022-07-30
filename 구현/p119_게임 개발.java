package algorithm;

import java.util.Scanner;
import java.util.*;

public class test {
	
	static int d;
	static void turn_left() {
		if (d != 0)
			d -= 1;
		else
			d = 3;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(); int m = s.nextInt();
		int x = s.nextInt(); int y = s.nextInt(); d = s.nextInt();
		int cnt = 1;
		int turn_time = 0;
		
		int[][] map = new int[n][m];
		int[][] visited = new int[n][m];
		visited[x][y] = 1;
		
		for (int i = 0; i < n; i++)
			for (int k = 0; k < m; k++)
				map[i][k] = s.nextInt();
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[] di = {0, 1, 2, 3};
		
		while (true) {
			turn_left();
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (map[nx][ny] == 0 && visited[nx][ny] == 0) {
				visited[nx][ny] = 1;
				x = nx; y = ny;
				cnt++;
				turn_time = 0;
				continue;
			}
			else 
				turn_time++;
			
			if (turn_time == 4) {
				nx = x - dx[d];
				ny = y - dy[d];
				if (map[nx][ny] == 0) {
					x = nx;
					y = ny;
				}
				else
					break;
				turn_time = 0;
			}
		}
		System.out.println(cnt);
	}
}
