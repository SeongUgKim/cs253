#include <iostream>
using namespace std;

long climbStairs(int n)
{
	long W[n + 1];
	W[1] = 1;
	W[2] = 2;
	for (int i = 3; i <= n; ++i)
		W[i] = W[i - 1] + W[i - 2];
	return W[n];
}

int main()
{
	cout << climbStairs(300) << endl;
}
