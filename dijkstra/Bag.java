import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
	private int N; 		  // Number of elements in bag
	private Node<Item> first; // beginning of bag

	// helper linked list class
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	public Bag() {
		first = null;
		N = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}
	
	public void add(Item item) {
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	public Iterator<Item> iterator() {
		return new ListIterator<Item> (first);
	}

	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;
		
		public ListIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext())  throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	public static void main(String[] args) {
		Bag<String> bag = new Bag<String>();
		String[] strs = {"Hello", "Hi", "Emory", "CS253"};
		for (String str : strs) {
			bag.add(str);
		}
		System.out.println("size of bag = " + bag.size());
		for (String s : bag) {
			System.out.println(s);
		}
	}

}

