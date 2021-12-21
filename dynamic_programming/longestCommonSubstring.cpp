#include <iostream>
#include <string>
#include <climits>
using namespace std;
// cache[i][j] : longest common substring of (0, i) substring of a and (0, j) substring of b
int lcs(string a, string b) {
	int n = a.size();
	int m = b.size();
	int ret = INT_MIN;
	int cache[n + 1][m + 1];
	for (int i = 0; i <= n; ++i) cache[i][0] = 0;
	for (int i = 0; i <= m; ++i) cache[0][i] = 0;
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= m; ++j) { 
			if (a[i - 1] == b[j - 1]) cache[i][j] = cache[i - 1][j - 1] + 1;
			else cache[i][j] = 0;
			ret = max(ret, cache[i][j]);
		}
	}
	return ret;
}

int main() 
{
	cout << lcs("ABCPQSAQ", "PQSABC") << endl;
}
