package com.interviewbit.binarytree.tries;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	private final Map<Character, TrieNode> children = new HashMap<>();
	private boolean endOfWord;

	Map<Character, TrieNode> getChildren() {
		return this.children;
	}

	boolean isEndOfWord() {
		return this.endOfWord;
	}

	void setEndOfWord(final boolean endOfWord) {
		this.endOfWord = endOfWord;
	}
}