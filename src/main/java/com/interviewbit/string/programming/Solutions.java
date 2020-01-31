package com.interviewbit.string.programming;

public class Solutions {
	public boolean isVowel(char a) {
		a = Character.toLowerCase(a);
        return (a == 'a') || (a == 'e') || (a == 'i') || (a == 'o') || (a == 'u');
    }

	public int solve(final String A) {
		int sum = 0;

		for (int i = 0; i < A.length(); i++) {
			if (this.isVowel(A.charAt(i))) {
				sum += A.length() - i;
			}
		}

		return sum % 10003;
	}

	public int solve2(final String A) {

		final String vow = "aeiouAEIOU";
		int count = 0;
		final int s = A.length();
		for (int i = 0; i < A.length(); i++) {
			if (vow.indexOf(A.charAt(i)) >= 0) {
				count += s - i;
			}
		}
		return count % 10003;
	}

	public boolean isPalindrom(final String input) {
		int i = 0;
		int j = input.length() - 1;
		while ((i < j) && (input.charAt(i) == input.charAt(j))) {
			i++;
			j--;
		}
        return i >= j;
    }

	public int solveMinCharPalindrom(String A) {
		int cnt = 0;
		while (A.length() > 0) {
			// if string becomes palindrome then break
			if (this.isPalindrom(A)) {
				break;
			} else {
				cnt++;
				// erase the last element of the string
				A = A.substring(0, A.length() - 1);
				// s.erase(s.begin() + s.length() - 1);
			}
		}

		return cnt;
	}

	void computeLPS(final String s, final int[] lps) {
		final int m = s.length();
		int len = 0;
		lps[0] = 0;
		int i = 1;
		while (i < m) {
			if (s.charAt(i) == s.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
	}

	public int palindromLPS(final String a) {
		StringBuilder s = new StringBuilder(a);
		s = s.reverse();
		final String str = a + "$" + s.toString();
		final int[] lps = new int[str.length()];
		this.computeLPS(str, lps);
		return (a.length() - lps[str.length() - 1]);
	}
}
