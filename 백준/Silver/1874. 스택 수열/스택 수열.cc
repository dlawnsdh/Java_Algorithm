#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	vector<int> v;
	vector<char> v1;
	stack<int> s;
	int N, count = 0;
	cin >> N;
	for (int i = 1; i <= N; i++) {
		int x;
		cin >> x;
		v.push_back(x);
	}
	int j = 1;
	int i = 0;
	while (i < N) {
		if (s.size() == 0 || s.top() != v[i]) {
			s.push(j);
			v1.push_back('+');
			j++;
		}
		else {
			s.pop();
			v1.push_back('-');
			i++;
		}
		count++;
		if (count > N * 2) {
			cout << "NO";
			break;
		}
	}
	if(count <= N * 2)
		for (auto e : v1)
			cout << e << "\n";
}