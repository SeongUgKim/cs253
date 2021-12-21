#include <iostream>
#include <string>
using namespace std;
// cache[i][j] = edit distance between (0, i) of substr a and (0, j) of substr b

int editDistance(string a, string b)
{
	int n = a.size();
	int m = b.size();
	int cache[n + 1][m + 1];
	for (int i = 0; i <= n; ++i) cache[i][0] = i;
	for (int i = 0; i <= m; ++i) cache[0][i] = i;
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= m; ++j) {
			if (a[i - 1] == b[j - 1]) cache[i][j] = cache[i - 1][j - 1];
			else cache[i][j] = min(cache[i - 1][j - 1], min(cache[i - 1][j], cache[i][j - 1])) + 1;
		}
	}
	return cache[n][m];
}

int main()
{
	cout << editDistance("relative", "active") << endl;
}

