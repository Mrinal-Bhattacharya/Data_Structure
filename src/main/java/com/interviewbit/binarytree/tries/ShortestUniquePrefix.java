package com.interviewbit.binarytree.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShortestUniquePrefix {
	public ArrayList<String> prefix(final ArrayList<String> A) {
		final ArrayList<String> res = new ArrayList<>();
		final Trie root = new Trie();
		for (int i = 0; i < A.size(); i++) {
			this.insert(A.get(i), root);
		}
		for (int i = 0; i < A.size(); i++) {
			res.add(this.getMinPrefix(root, A.get(i)));
		}
		return res;
	}

	private String getMinPrefix(final Trie root, final String word) {
		Trie current = root;
		String str = "";
		for (int i = 0; i < word.length(); i++) {
			final char ch = word.charAt(i);
			final Trie node = current.getChildren().get(ch);
			if (node.freq == 1) {
				str += ch;
				return str;
			}
			str += ch;
			current = node;
		}
		return str;
	}

	void insert(final String word, final Trie root) {
		Trie current = root;
		for (int i = 0; i < word.length(); i++) {
			current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new Trie());
			current.freq++;
		}
		current.setEndOfWord(true);
	}

	public static void main(final String[] args) {
		final ArrayList<String> A = new ArrayList<>();
		A.add("bearcat");
		A.add("bert");
		new ShortestUniquePrefix().prefix(A);
	}
}

class Trie {
	private final Map<Character, Trie> children = new HashMap<>();
	private boolean endOfWord;
	public int freq;

	public Trie() {
		this.freq = 0;
	}

	void setFreq(final int i) {
		this.freq = i;
	}

	Map<Character, Trie> getChildren() {
		return this.children;
	}

	boolean isEndOfWord() {
		return this.endOfWord;
	}

	void setEndOfWord(final boolean endOfWord) {
		this.endOfWord = endOfWord;
	}
}