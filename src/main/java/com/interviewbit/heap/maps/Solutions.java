package com.interviewbit.heap.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solutions {
	Map<Integer, Node> map;
	Node start;
	Node end;
	int capacity;

	public Solutions(final int capacity) {
		this.map = new HashMap<>();
		this.start = new Node(0, 0);
		this.end = new Node(0, 0);
		this.capacity = capacity;
		this.start.next = this.end;
		this.end.prev = this.start;
	}

	public int get(final int key) {
		if (this.map.containsKey(key)) {
			final Node node = this.map.get(key);
			this.removeNode(node);
			this.addNode(node);

			return node.val;
		}
		return -1;
	}

	private void addNode(final Node node) {
		node.next = this.start.next;
		this.start.next = node;
		node.prev = this.start;
		node.next.prev = node;
	}

	private void removeNode(final Node node) {
		final Node temp = node.next;
		node.prev.next = temp;
		temp.prev = node.prev;
	}

	public void set(final int key, final int value) {
		final Node node = new Node(key, value);

		if (this.map.containsKey(key)) {
			final Node temp = this.map.get(key);
			this.removeNode(temp);
			this.addNode(node);
		} else {
			if (this.capacity == this.map.size()) {
				final Node temp = this.end.prev;
				this.removeNode(temp);
				this.map.remove(temp.key);
			}

			this.addNode(node);
		}

		this.map.put(key, node);
	}

	public ArrayList<Integer> dNums(final ArrayList<Integer> A, final int B) {
		final ArrayList<Integer> ans = new ArrayList<>();
		if (B > A.size()) {
			return ans;
		}

		final Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < B; i++) {
			map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
		}

		ans.add(map.size());

		for (int i = B; i < A.size(); i++) {
			map.put(A.get(i - B), map.get(A.get(i - B)) - 1);
			if (map.get(A.get(i - B)) == 0) {
				map.remove(A.get(i - B));
			}

			map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);

			ans.add(map.size());
		}

		return ans;
	}

	public static void main(final String[] args) {
		final ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(2);
		A.add(1);
		A.add(3);
		A.add(4);
		A.add(3);
		new Solutions(10).dNums(A, 3);
	}

}

class Node {
	public int key;
	public int val;
	public Node prev;
	public Node next;

	public Node(final int key, final int val) {
		this.key = key;
		this.val = val;
		this.prev = null;
		this.next = null;
	}
}