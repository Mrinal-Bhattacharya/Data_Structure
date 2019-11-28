package com.interviewbit.string.parsing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solutions {
	public int atoi(final String A) {
		int i = 0;
		final int length = A.length();
		long num = 0;
		boolean sign = true;

		while ((i < length) && (A.charAt(i) == ' ')) {
			++i;
		}

		if (i == A.length()) {
			return 0; // just have white space
		}

		if (A.charAt(i) == '-') { // negative
			sign = false;
			++i;
		} else if (A.charAt(i) == '+') {
			++i;
		}

		while ((i < A.length()) && (A.charAt(i) >= '0') && (A.charAt(i) <= '9')) {
			num = Math.abs(num);
			num = (num * 10) + (A.charAt(i) - '0');

			if (!sign) {
				num = -num;
			}
			if (num > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			} else if (num < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			++i;
		}
		return (int) num;
	}

	public int compareVersion(final String A, final String B) {
		final String[] v1 = A.split("\\.");
		final String[] v2 = B.split("\\.");

		final int size = Math.max(v1.length, v2.length);
		int i = 0;
		while (i < size) {
			try {
				final long ver1 = i >= v1.length ? 0 : Long.parseLong(v1[i]);
				final long ver2 = i >= v2.length ? 0 : Long.parseLong(v2[i]);

				if (ver1 > ver2) {
					return 1;
				}
				if (ver1 < ver2) {
					return -1;
				}
			} catch (final Exception e) {
				final int r = v1[i].compareTo(v2[i]);
				if (r != 0) {
					return r > 0 ? 1 : -1;
				}
			}
			i++;
		}

		return 0;
	}

	/*
	 * Using Regex = (0 or more Spaces) followed by (- or + sign ) followed by (0 to
	 * 9 numbers) 0 or more followed by (.) followed by (0 - 9 numbers) one or more
	 * followed by (e) followed by (- or + sign) followed by (0 to 9 numbers) one or
	 * more followed by (0 or more spaces)
	 */
	public int isNumber(final String A) {
		return (A.matches("\\s*[\\-\\+]?([0-9]*\\.?)?[0-9]+(e[\\-\\+]?[0-9]+)?\\s*")) ? 1 : 0;
	}

	public ArrayList<String> restoreIpAddresses(final String s) {
		final ArrayList<String> res = new ArrayList<>();
		if ((s.length() < 4) || (s.length() > 12)) {
			return res;
		}
		this.dfs(s, "", res, 0);
		System.out.println(res.size());
		return res;
	}

	public void dfs(final String s, final String tmp, final ArrayList<String> res, final int count) {
		if ((count == 3) && this.isValid(s)) {
			res.add(tmp + s);
			return;
		}
		for (int i = 1; (i < 4) && (i < s.length()); i++) {
			final String substr = s.substring(0, i);
			if (this.isValid(substr)) {
				this.dfs(s.substring(i), tmp + substr + '.', res, count + 1);
			}
		}
	}

	public boolean isValid(final String s) {
		if (s.charAt(0) == '0') {
			return s.equals("0");
		}
		final int num = Integer.parseInt(s);
		return (num <= 255) && (num > 0);
	}

	public static ArrayList<String> restoreIpAddresses2(final String A) {
		if ((A.length() < 3) || (A.length() > 12)) {
			return new ArrayList<>();
		}
		return Solutions.convert(A);
	}

	private static ArrayList<String> convert(final String s) {
		final ArrayList<String> l = new ArrayList<>();
		final int size = s.length();

		String snew = s;

		for (int i = 1; i < (size - 2); i++) {
			for (int j = i + 1; j < (size - 1); j++) {
				for (int k = j + 1; k < size; k++) {
					System.out.println("i " + i + " j " + j + " k " + k);
					snew = snew.substring(0, k) + "." + snew.substring(k);
					System.out.println("Step 1 " + snew);
					snew = snew.substring(0, j) + "." + snew.substring(j);
					System.out.println("Step 2 " + snew);
					snew = snew.substring(0, i) + "." + snew.substring(i);
					System.out.println("Step 3 " + snew);

					if (Solutions.isValid2(snew)) {
						System.out.println(">>>>>>>>>>>>>>  " + snew);
						l.add(snew);
					}
					snew = s;
				}
			}
		}

		Collections.sort(l, new Comparator<String>() {
			@Override
			public int compare(final String o1, final String o2) {
				final String a1[] = o1.split("[.]");
				final String a2[] = o2.split("[.]");

				int result = -1;
				for (int i = 0; (i < 4) && (result != 0); i++) {
					result = a1[i].compareTo(a2[i]);
				}
				return result;
			}
		});
		return l;

	}

	private static boolean isValid2(final String ip) {
		final String a[] = ip.split("[.]");
		for (final String s : a) {
			final int i = Integer.parseInt(s);
			if ((s.length() > 3) || (i < 0) || (i > 255)) {
				return false;
			}
			if ((s.length() > 1) && (i == 0)) {
				return false;
			}
			if ((s.length() > 1) && (i != 0) && (s.charAt(0) == '0')) {
				return false;
			}
		}

		return true;
	}

	public static ArrayList<String> restoreIpAddresses3(final String s) {
		final int len = s.length();
		final ArrayList<String> res = new ArrayList<>();
		if (len > 12) {
			return res;
		}

		for (int i = 1; (i < 4) && (i < (len - 2)); i++) {
			for (int j = i + 1; (j < (i + 4)) && (j < (len - 1)); j++) {
				for (int k = j + 1; (k < (j + 4)) && (k < len); k++) {
					final String s1 = s.substring(0, i);
					final String s2 = s.substring(i, j);
					final String s3 = s.substring(j, k);
					final String s4 = s.substring(k, len);

					if (Solutions.isValid3(s1) && Solutions.isValid3(s2) && Solutions.isValid3(s3)
							&& Solutions.isValid3(s4)) {
						res.add(s1 + "." + s2 + "." + s3 + "." + s4);
					}
				}
			}
		}

		return res;
	}

	public static boolean isValid3(final String s) {
		if ((s.length() > 3) || s.isEmpty() || ((s.charAt(0) == '0') && (s.length() > 1))
				|| (Integer.parseInt(s) > 255)) {
			return false;
		}
		return true;
	}

	public static void main(final String[] args) {
		new Solutions();
		Solutions.restoreIpAddresses2("25525511135");
	}
}
