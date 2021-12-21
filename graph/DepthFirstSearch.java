public class DepthFirstSearch {
	private boolean[] marked;
	private int count;

	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		validateVertex(s);
		dfs(G, s);
	}
	private void dfs(Graph G, int v) {
		Stack<Integer> s = new Stack<Integer>();
		count++;
		s.push(v);	
		while (!s.isEmpty()) {
			int w = s.pop();
			marked[w] = true;
			count++;
			for (int u : G.adj(w)) {
				if (marked[u]) continue;
				s.push(u);
			}
		}
	}
	private void dfsRecursive(Graph G, int v) {
		count++;
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	public boolean marked(int v) {
		validateVertex(v);
		return marked[v];
	}

	public int count() {
		return count;
	}

	private void validateVertex(int v) {
		int V = marked.length;
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex "  + v + " is not between 0 and " + (V - 1));
	}
	
	public static void main(String[] args) {
		In in = new In(args[0]);
		Graph G = new Graph(in);
		int s = Integer.parseInt(args[1]);
		DepthFirstSearch search = new DepthFirstSearch(G, s);	
		for (int v = 0; v < G.V(); v++) 
			if (search.marked(v))
				System.out.println(v + " ");
		System.out.println("\n");
		if (search.count() != G.V()) System.out.println("Not connected");
		else System.out.println("connected");
	}
}
