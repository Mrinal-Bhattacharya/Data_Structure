package com.interviewbit.binarytree.tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class HotelReviews {
	public ArrayList<Integer> solve(final String A, final ArrayList<String> B) {
		final TrieNode root = new TrieNode();
		final String[] keywords = A.split("_");
		for (final String keyword : keywords) {
			this.insert(keyword, root);
		}
		final Map<Integer, ArrayList<Integer>> treemap = new TreeMap<>(Collections.reverseOrder());
		for (int i = 0; i < B.size(); i++) {
			final String[] words = B.get(i).split("_");
			int matches = 0;
			for (int k = 0; k < words.length; k++) {
				if (this.containsNode(words[k], root)) {
					matches++;
				}
			}
			this.addToMap(treemap, matches, i);
		}
		final ArrayList<Integer> res = new ArrayList<>();
		final Set<Entry<Integer, ArrayList<Integer>>> set = treemap.entrySet();
		for (final Entry<Integer, ArrayList<Integer>> entry : set) {
			res.addAll(entry.getValue());
		}
		return res;
	}

	public void addToMap(final Map<Integer, ArrayList<Integer>> hmap, final int matches, final int rindex) {
		final ArrayList<Integer> temp = hmap.getOrDefault(matches, new ArrayList<Integer>());
		temp.add(rindex);
		Collections.sort(temp);
		hmap.put(matches, temp);
	}

	void insert(final String word, final TrieNode root) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());
		}
		current.setEndOfWord(true);
	}

	boolean containsNode(final String word, final TrieNode root) {
		TrieNode current = root;

		for (int i = 0; i < word.length(); i++) {
			final char ch = word.charAt(i);
			final TrieNode node = current.getChildren().get(ch);
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current.isEndOfWord();
	}

	public void delete(final String word, final TrieNode root) {
		this.delete(root, word, 0);
	}

	private boolean delete(final TrieNode current, final String word, final int index) {
		if (index == word.length()) {
			if (!current.isEndOfWord()) {
				return false;
			}
			current.setEndOfWord(false);
			return current.getChildren().isEmpty();
		}
		final char ch = word.charAt(index);
		final TrieNode node = current.getChildren().get(ch);
		if (node == null) {
			return false;
		}
		final boolean shouldDeleteCurrentNode = this.delete(node, word, index + 1) && !node.isEndOfWord();

		if (shouldDeleteCurrentNode) {
			current.getChildren().remove(ch);
			return current.getChildren().isEmpty();
		}
		return false;
	}
}
