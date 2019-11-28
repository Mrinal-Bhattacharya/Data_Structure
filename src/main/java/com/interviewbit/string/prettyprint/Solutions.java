package com.interviewbit.string.prettyprint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solutions {
	public ArrayList<String> fullJustify(final ArrayList<String> a, final int b) {
		final ArrayList<String> res = new ArrayList<>();
		final int n = a.size();
		int index = 0;
		while (index < n) {
			int totalChars = a.get(index).length();
			int last = index + 1;
			while (last < n) {
				if ((totalChars + 1 + a.get(last).length()) > b) {
					break;
				}
				totalChars += 1 + a.get(last).length();
				last++;
			}
			final int gaps = last - index - 1;
			final StringBuilder builder = new StringBuilder();
			if ((last == n) || (gaps == 0)) {
				for (int i = index; i < last; i++) {
					builder.append(a.get(i));
					builder.append(" ");
				}
				builder.deleteCharAt(builder.length() - 1);
				while (builder.length() < b) {
					builder.append(" ");
				}
			} else if (totalChars == b) {
				for (int i = index; i < (last - 1); i++) {
					builder.append(a.get(i));
					builder.append(" ");
				}
				builder.append(a.get(last - 1));
			} else {
				final int spaces = b - (totalChars / gaps);
				final int rest = b - (totalChars % gaps);
				for (int i = index; i < (last - 1); i++) {
					builder.append(a.get(i));
					builder.append(" ");
					for (int j = 0; j < (spaces + ((i - index) < rest ? 1 : 0)); j++) {
						builder.append(" ");
					}
				}
				builder.append(a.get(last - 1));
			}
			res.add(builder.toString());
			index = last;

		}
		return res;
	}

	public String convert(final String A, final int B) {
		if (B == 1) {
			return A;
		}
		final char[] str1 = A.toCharArray();

		// Find length of string
		final int len = A.length();

		// Create an array of
		// strings for all n rows
		final String[] arr = new String[B];
		Arrays.fill(arr, "");
		int row = 0;
		boolean down = true;
		for (int i = 0; i < len; ++i) {
			arr[row] += (str1[i]);
			if (row == (B - 1)) {
				down = false;
			} else if (row == 0) {
				down = true;
			}
			if (down) {
				row++;
			} else {
				row--;
			}
		}
		String result = "";
		for (int i = 0; i < B; ++i) {
			result += arr[i];
		}
		return result;
	}

	public ArrayList<String> prettyJSON(final String A) {
		final ArrayList<String> ans = new ArrayList<>();

		int openBrace = 0;
		int closedBrace = 0;
		final StringBuilder sb = new StringBuilder("");
		final char[] chars = A.toCharArray();

		for (final char c : chars) {
			if ("{[".indexOf(c) != -1) {
				if (sb.length() != 0) {
					ans.add(String.join("", Collections.nCopies(openBrace - closedBrace, "\t")) + sb.toString());
					sb.setLength(0);
				}
				openBrace++;
				sb.append(c);
				ans.add(String.join("", Collections.nCopies(openBrace - closedBrace - 1, "\t")) + sb.toString());
				sb.setLength(0);
			} else if ("}]".indexOf(c) != -1) {
				if (sb.length() != 0) {
					ans.add(String.join("", Collections.nCopies(openBrace - closedBrace, "\t")) + sb.toString());
					sb.setLength(0);
				}
				closedBrace++;
				sb.append(c);
			} else if (c == ',') {
				sb.append(',');
				ans.add(String.join("", Collections.nCopies(openBrace - closedBrace, "\t")) + sb.toString());
				sb.setLength(0);
			} else {
				sb.append(c);
			}
		}
		if (sb.length() != 0) {
			ans.add(sb.toString());
		}

		return ans;
	}
}
