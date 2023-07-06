#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int cnt = 0; 
int n, m, t;
int graph[100][100];
bool visited[100][100] = { false, };
int dx[] = { -1,0,1,0 };
int dy[] = { 0,1,0,-1 };
void dfs(int y, int x) {
	visited[y][x] = true;
	cnt++;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
			if (graph[ny][nx] == 0 && !visited[ny][nx]) 
				dfs(ny, nx);
		}
	}
}
int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	cin >> m >> n >> t;
	for (int i = 0; i < t; i++) {
		int x1, x2, y1, y2;
		cin >> x1 >> y1 >> x2 >> y2;
		for (int y = y1; y < y2; y++)
			for (int x = x1; x < x2; x++)
				graph[y][x] = 1;
	}
	vector<int> v;
	for (int y = 0; y < m; y++) {
		for (int x = 0; x < n; x++) {
			if (graph[y][x] == 0 && !visited[y][x]) {
				cnt = 0;
				dfs(y, x);
				v.push_back(cnt);
			}
		}
	}
	cout << v.size() << endl;
	sort(v.begin(), v.end());
	for (auto e : v)
		cout << e << " ";
}
