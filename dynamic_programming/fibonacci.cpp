#include<iostream>
using namespace std;
long fib(int n ) 
{
	if (n == 1 || n == 2) return 1;
	long F[n + 1];
	F[1] = 1;
	F[2] = 1;
	for (int k = 3; k <= n; ++k)
		F[k] = F[k - 1] + F[k - 2];
	return F[n];
}

int main()
{
	cout << fib(30) << endl;
}
