import java.util.Arrays;

public class KruskalMST {
	private double weight;
	private Queue<Edge> mst = new Queue<Edge>();

	public KruskalMST(EdgeWeightedGraph G) {
		// create array of edges, sorted by weight;
		Edge[] edges = new Edge[G.E()];
		int t = 0; 
		for (Edge e : G.edges()) {
			edges[t++] = e;
		}
		Arrays.sort(edges);
		// run greedy algorithm
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(G.V());
		for (int i = 0; i < G.E() && mst.size() < G.V() - 1; ++i) {
			Edge e = edges[i];
			int v = e.either();
			int w = e.other(v);
			// v-w does not create a cycle
			if (uf.find(v) != uf.find(w)) {
				uf.union(v, w);
				mst.enqueue(e);
				weight += e.weight();
			}
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public double weight() {
		return weight;
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		KruskalMST mst  = new KruskalMST(G);
		for (Edge e : mst.edges()) {
			StdOut.println(e);
		}
		StdOut.printf("%.5f\n", mst.weight());
	}
}


