#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> adj;
vector<bool> visited;
vector<int> order;

void dfs(int here)
{
	cout << "DFS visits " << here << endl;
	visited[here] = true;
	for (int i = 0; i < adj[here].size(); ++i) {
		int there = adj[here][i];
		if (!visited[there]) dfs(there);
	}
	order.push_back(here);	
}

void dfsAll()
{
	visited = vector<bool>(adj.size(), false);
	for (int i = 0; i < adj.size(); ++i)
		if (!visited[i]) dfs(i);
	reverse(order.begin(), order.end());
}
