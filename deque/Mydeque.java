import java.io.*;
import java.util.*;

public class Mydeque<Item> {
	private class Node {
		public Node prev, next;
		public Item item;

		public Node(Item item) {
			this.item = item;
			this.prev = null;
			this.next = null;
		}
	}

	private Node head;
	private Node tail;
	private int N;


	public Mydeque() {
		head = null;
		tail = null;
		N = 0;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void addFirst(Item item) {
		Node newNode = new Node(item);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
			N++;
			return;
		}

		head.prev = newNode;
		newNode.next = head;
		head = newNode;
		N++;
	}

	public void addLast(Item item) {
		Node newNode = new Node(item);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
			N++;
			return;
		}
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		N++;
		return;
	}

	public Item removeFirst() throws NoSuchElementException {
		Item ret;
		if (isEmpty()) throw new NoSuchElementException();
		N--;
		ret = this.head.item;
		head = head.next;
		if (head == null) {
			tail = null;
			return ret;
		}
		head.prev = null;
		return ret;
	}

	public Item removeLast() throws NoSuchElementException {
		Item ret;
		if (isEmpty()) throw new NoSuchElementException();
		N--;
		ret = this.tail.item;
		tail = tail.prev;
		if (tail == null) {
			head = null;
			return ret;
		}
		tail.next = null;
		return ret;
	}

	public static void main(String[] args) {
		Mydeque<String> deq = new Mydeque<>();

		assert(deq.isEmpty() == true);
		deq.addFirst("l");
		deq.addLast("a");	
		deq.addFirst("o");
		deq.addFirst("h");
		assert(deq.isEmpty() == false);
		assert(deq.size() == 4);
	}
}

