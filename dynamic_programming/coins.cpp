#include <vector>
#include <cstring>
using namespace std;

// topdown
int cache[301][5001];

int topdown(int amount, vector<int>& coins,int index)
{
	int n = coins.size();	
	if (amount == 0) return 1;
	if (index >= n) return 0;
	int& ret = cache[index][amount];
	if (ret != -1) return ret;
	if (coins[index] > amount) return ret = topdown(amount, coins, index + 1);
	return ret = topdown(amount, coins, index + 1) + topdown(amount - coins[index], coins, index);
}

int topdownSolve(int amount, vector<int>& coins) 
{
	memset(cache, -1, sizeof(cache));
	return topdown(amount, coins, 0);
}

// bottom-up

int bottomupSolve(int amount, vector<int>& coins) 
{
	int n = coins.size();
	int dp[n + 1][amount + 1];
	for (int i = 0; i <= n; ++i) {
		for (int j = 0; j <= amount; ++j) {
			if (i == 0) {
				if (j > 0) dp[i][j] = 0;
			}
			else if (j == 0) dp[i][j] = 1;
			else if (coins[i - 1] > amount) dp[i][j] = dp[i - 1][j];
			else dp[i][j] = dp[i - 1][j] + dp[i][amount - coins[i - 1]];
		}
	}
	return dp[n][amount];
}

int main() 
{
	return 0;
}
