public class TST<Value> {
	private int n;
	private Node<Value> root;

	private static class Node<Value> {
		private char c;
		private Node<Value> left, mid, right;
		private Value val;
	}

	public TST() {
	}

	public int size() {
		return n;
	}

	public boolean contains(String key) {
		if (key == null) throw new IllegalArgumentException();
		return get(key) != null;
	}

	public Value get(String key) {
		if (key == null) throw new IllegalArgumentException();
		if (key.length() == 0) throw new IllegalArgumentException();
		Node<Value> x = get(root, key, 0);
		if (x == null) return null;
		return x.val;
	}

	private Node<Value> get(Node<Value> x, String key, int d) {
		if (x == null) return null;
		if (key.length() == 0) throw new IllegalArgumentException();
		char c = key.charAt(d);
		if (c < x.c) return get(x.left, key, d);
		if (c > x.c) return get(x.right, key, d);
		if (d < key.length() - 1) return get(x.mid, key, d + 1);
		return x;
	}

	public void put(String key, Value val) {
		if (key == null) throw new IllegalArgumentException();
		if (!contains(key)) n++;
		else if (val == null) n--;
		root = put(root, key, val, 0);
	}

	private Node<Value> put(Node<Value> x, String key, Value val, int d) {
		char c = key.charAt(d);
		if (x == null) {
			x = new Node<Value>();
			x.c = c;
		}
		if (c < x.c) x.left = put(x.left, key, val, d);
		else if (c > x.c) x.right = put(x.right, key, val, d);
		else if (d < key.length() - 1) x.mid = put(x.mid, key, val, d + 1);
		x.val = val;
		return x;
	}
}

