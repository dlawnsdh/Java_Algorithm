#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio;
	cin.tie(0);
	string s;
	cin >> s;
	int c[10] = { 0 };
	for (int i = 0; i < s.size(); i++) {
		c[s[i] - 48]++;
	}
	int num = 0;
	for (int i = 0; i < 10; i++)
		if (i != 6 && i != 9)
			num = max(num, c[i]);
	int b = c[6] + c[9];
	num = max(num, b / 2 + b % 2);
	cout << num;
}