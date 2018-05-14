package com.java.ds.basic.string;

public class Permutation {
	public static void main(final String[] args) {
		final String s = "Mrinal";
		final int index = 2;
		final StringBuilder sb = new StringBuilder(s);
		final char c = sb.charAt(index);
		// System.out.println(c);
		sb.deleteCharAt(index);
		// System.out.println(sb.toString());
		sb.insert(index, c);
		// System.out.println(sb.toString());

		final Permutation stringTest = new Permutation();
		stringTest.permute("ABC");

	}

	void permute(final String s) {
		this.premuteHelper(new StringBuilder(s), new StringBuilder());
	}

	private void premuteHelper(final StringBuilder str, final StringBuilder chosen) {
		// indent(chosen.length());
		// System.out.println(str.toString() + " : " + chosen.toString());
		if (str.length() == 0) {
			System.out.println(chosen.toString());
		}
		for (int i = 0; i < str.length(); i++) {
			final char c = str.charAt(i);
			chosen.append(c);
			str.deleteCharAt(i);
			this.premuteHelper(str, chosen);
			str.insert(i, c);
			chosen.deleteCharAt(chosen.length() - 1);
		}

	}

	void indent(final int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("....");
		}
	}
}
