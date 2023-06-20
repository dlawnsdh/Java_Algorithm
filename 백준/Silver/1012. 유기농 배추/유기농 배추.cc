#include <iostream>
#include <vector>
using namespace std;
int test, n, m, l;
int graph[50][50];
bool dfs(int X, int Y) {
	if (X < 0 || X >= n || Y < 0 || Y >= m)
		return false;
	if (graph[X][Y] == 1) {
		graph[X][Y] = 0;
		dfs(X - 1, Y);
		dfs(X + 1, Y);
		dfs(X, Y - 1);
		dfs(X, Y + 1);
		return true;
	}
	return false;
}
int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	cin >> test;
	for (int j = 0; j < test; j++) {
		cin >> n >> m >> l;
		for (int i = 0; i < l; i++) {
			int x, y;
			cin >> x >> y;
			graph[x][y] = 1;
		}
		int count = 0;
		for (int i = 0; i < n; i++)
			for (int k = 0; k < m; k++)
				if (dfs(i, k))
					count++;
		cout << count << endl;
		int graph[50][50] = { 0 };
	}
}