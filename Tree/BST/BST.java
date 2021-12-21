import java.util.*;

public class BST<Key extends Comparable<Key>, Value> {
	private class Node {
		public Value val;
		public Key key;
		public Node left, right;
		public int N;

		public Node (Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}

	private Node root;

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null) return 0;
		return x.N;
	}

	public boolean contains(Key key) {
		return get(key) != null;
	}

	public Value get(Key key) {
		Node x = get(key, root);
		if (x != null) return x.val;
		return null;
	}

	private Node get(Key key, Node x) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) return get(key, x.left);
		if (cmp > 0) return get(key, x.right);
		return x;
	}

	public void put(Key key, Value val) {
		root = put(key, val, root);
	}

	private Node put(Key key, Value val, Node x) {
		if (x == null) return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0) x.left = put(key, val, x.left);
		else if (cmp > 0) x.right = put(key, val, x.right);
		else x.val = val;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	public void deleteMin() {
		if (isEmpty()) throw new NoSuchElementException();
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void deleteMax() {
		if (isEmpty()) throw new NoSuchElementException();
		root = deleteMax(root);
	}

	private Node deleteMax(Node x) {
		if (x.right == null) return x.left;
		x.right = deleteMax(x.right);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Key min() {
		if (isEmpty()) throw new NoSuchElementException();
		return min(root).key;
	}

	private Node min(Node x) {
		if (x.left == null) return x;
		return min(x.left);
	}

	public Key max() {
		if (isEmpty()) throw new NoSuchElementException();
		return max(root).key;
	}

	private Node max(Node x) {
		if (x.right == null) return x.right;
		return max(x.right);
	}

	public void delete(Key key) {
		if (key == null) throw new NoSuchElementException();
		root = delete(root, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) x.left = delete(x.left, key);
		if (cmp > 0) x.right = delete(x.right, key); 
		else {
			if (x.right == null) return x.left;
			if (x.left == null) return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
}
