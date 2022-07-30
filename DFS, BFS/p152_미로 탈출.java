package algorithm;

import java.util.*;

class Node {
	public int x;
	public int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class test {
	
	public static int[][] map = new int[200][200];
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int n, m;
	
	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			x = node.x;
			y = node.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (map[nx][ny] == 0)
					continue;
				if (map[nx][ny] == 1) {
					map[nx][ny] = map[x][y] + 1;
					q.add(new Node(nx, ny));
				}
			}
		}
		return map[n - 1][m - 1];
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt(); m = s.nextInt();
		s.nextLine();
		for (int i = 0; i < n; i++) {
			String str = s.nextLine();
			for (int k = 0; k < m; k++)
				map[i][k] = str.charAt(k) - '0';
		}
		System.out.println(bfs(0, 0));
	}
}
