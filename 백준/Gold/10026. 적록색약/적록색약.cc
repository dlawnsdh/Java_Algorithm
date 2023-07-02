#include <iostream>
#include <string>
#include <vector>
using namespace std;
int n;
int cnt_R = 0;
int cnt_G = 0;
int cnt_B = 0;
int cnt_RG = 0;
vector<char> graph[100];
bool visited[100][100];
int dx[] = { -1,0,1,0 };
int dy[] = { 0,1,0,-1 };
void dfs_R(int x, int y) {
	visited[x][y] = true;
	cnt_R++;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			if (graph[nx][ny] == 'R' && !visited[nx][ny]) {

				dfs_R(nx, ny);
			}
		}
	}
}
void dfs_G(int x, int y) {
	visited[x][y] = true;
	cnt_G++;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			
			if (graph[nx][ny] == 'G' && !visited[nx][ny]) {

				dfs_G(nx, ny);
			}
			
		}
	}
}
void dfs_B(int x, int y) {
	visited[x][y] = true;
	cnt_B++;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			
			if (graph[nx][ny] == 'B' && !visited[nx][ny]) {

				dfs_B(nx, ny);
			}
		}
	}
}
int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	cin >> n;
	cin.ignore();
	for (int i = 0; i < n; i++) {
		string s;
		getline(cin, s);
		for (int k = 0; k < s.size(); k++)
			graph[i].push_back(s[k]);
	}
	vector<int> v_R;
	vector<int> v_G;
	vector<int> v_B;
	vector<int> v_RG;
	for (int x = 0; x < n; x++)
		for (int y = 0; y < n; y++) {
			if (graph[x][y] == 'R' && !visited[x][y]) {
				cnt_R = 0;
				dfs_R(x, y);
				v_R.push_back(cnt_R);
				continue;
			}
			if (graph[x][y] == 'G' && !visited[x][y]) {
				cnt_G = 0;
				dfs_G(x, y);
				v_G.push_back(cnt_G);
				continue;
			}
			if (graph[x][y] == 'B' && !visited[x][y]) {
				cnt_B = 0;
				dfs_B(x, y);
				v_B.push_back(cnt_B);
				continue;
			}
		}
	for (int x = 0; x < n; x++)
		for (int y = 0; y < n; y++) {
			visited[x][y] = false;
			if (graph[x][y] == 'G')
				graph[x][y] = 'R';
		}
	for (int x = 0; x < n; x++)
		for (int y = 0; y < n; y++) {
			if (graph[x][y] == 'R' && !visited[x][y]) {
				cnt_R = 0;
				dfs_R(x, y);
				v_RG.push_back(cnt_R);
			}
		}
	cout << v_R.size() + v_G.size() + v_B.size() << endl << v_RG.size() + v_B.size();
}