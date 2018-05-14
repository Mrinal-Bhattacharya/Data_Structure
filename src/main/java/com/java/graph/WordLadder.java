package com.java.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	int shortestChainLen(final String start, final String target, final Set<String> dic) {
		final Queue<Item> q = new LinkedList<>();
		q.add(new Item(start, 1));
		while (!q.isEmpty()) {
			final Item curr = q.poll();
			for (final Iterator iterator = dic.iterator(); iterator.hasNext();) {
				final String s = (String) iterator.next();
				if (this.isadjacent(curr.word, s)) {
					final Item item = new Item(s, curr.len + 1);
					q.add(item);
					iterator.remove();
					if (s.equals(target)) {
						return item.len;
					}
				}

			}
		}
		return 0;
	}

	private boolean isadjacent(final String a, final String b) {
		int count = 0;
		final int n = a.length();
		for (int i = 0; i < n; i++) {
			if (a.charAt(i) != b.charAt(i)) {
				count++;
			}
			if (count > 1) {
				return false;
			}
		}
		return count == 1 ? true : false;
	}

	public static void main(final String[] args) {
		final Set<String> D = new HashSet<>();
		D.add("poon");
		D.add("plee");
		D.add("same");
		D.add("poie");
		D.add("plie");
		D.add("poin");
		D.add("plea");
		final String start = "toon";
		final String target = "plea";
		System.out.println("Length of shortest chain is: " + new WordLadder().shortestChainLen(start, target, D));
	}
}

class Item {

	String word;
	int len;

	public Item(final String start, final int len) {
		this.word = start;
		this.len = len;
	}
}