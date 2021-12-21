#include <vector>
using namespace std;
const int MAX_V = 10000;
struct Edge 
{
	int target, capacity, flow;
	Edge* reverse;
	int residualCapaicty() const
	{
		return capacity - flow;
	}
	void push(int amt) 
	{
		flow += amt;
		reverse->flow -= amt;
	}
}

vector<Edge*> adj[MAX_V];

void addEdge(int u, int v, int capacity) 
{
	Edge* uv = new Edge();
	Edge* vu = new Edge();
	uv->target = v;
	uv->capacity = capacity;
	uv->flow = 0;
	uv->reverse = vu;
	vu->target = u;
	vu->capacity = 0;
	vu->flow = 0;
	vu->reverse = uv;
	adj[u].push_back(uv);
	adj[v].push_back(vu);
}
