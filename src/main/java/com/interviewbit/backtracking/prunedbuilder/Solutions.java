package com.interviewbit.backtracking.prunedbuilder;

import java.util.ArrayList;

public class Solutions {
	public ArrayList<String> generateParenthesis(final int A) {
		final ArrayList<String> result = new ArrayList<>();
		this.parenthesisHelper("", A, A, result);
		return result;
	}

	private void parenthesisHelper(final String output, final int open, final int close,
			final ArrayList<String> result) {
		if ((close == 0) && (open == 0)) {
			result.add(output);
			return;
		}
		if (open > 0) {
			this.parenthesisHelper(output + "(", open - 1, close, result);
		}
		if (open < close) {
			this.parenthesisHelper(output + ")", open, close - 1, result);
		}

	}

	private void parenthesisHelper(final String output, final int open, final int close, final int pairs,
			final ArrayList<String> result, final int a) {
		System.out.println("output: " + output);
		if ((open == pairs) && (close == pairs) && (output.length() == (2 * a))) {
			System.out.println("\t Adding to result");
			result.add(output);
		} else {
			if (open < pairs) {
				System.out.println("\t Adding ( ");
				this.parenthesisHelper(output + "(", open + 1, close, pairs, result, a);
			}
			if (close < open) {
				System.out.println("\t Adding ) ");
				this.parenthesisHelper(output + ")", open, close + 1, pairs, result, a);
			}
		}
	}

	public ArrayList<ArrayList<String>> partition(final String a) {
		final ArrayList<ArrayList<String>> ans = new ArrayList<>();
		this.partitionHelper(ans, new ArrayList<String>(), a, 0);
		return ans;
	}

	private void partitionHelper(final ArrayList<ArrayList<String>> ans, final ArrayList<String> temp, final String a,
			final int idx) {
		if (idx == a.length()) {
			ans.add(new ArrayList<>(temp));
			return;
		}
		for (int i = idx; i < a.length(); i++) {
			final String sb = a.substring(idx, i + 1);

			if (this.isPalindrome(sb)) {
				temp.add(sb);
				this.partitionHelper(ans, temp, a, i + 1);
				temp.remove(temp.size() - 1);
			}
		}

	}

	private boolean isPalindrome(final String s) {
		return new StringBuilder(s).reverse().toString().equals(s);
	}

	public static void main(final String[] args) {
		final String str = "abc";
		System.out.println(str.substring(0, 1));
		final ArrayList<String> result = new Solutions().generateParenthesis(3);
		System.out.println("*********Result*******");
		for (final String s : result) {
			System.out.println(s);
		}
	}
}
