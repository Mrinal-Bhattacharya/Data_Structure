package com.interviewbit.string.math;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solutions {
	public int romanToInt(final String A) {
		int res = 0;

		for (int i = 0; i < A.length(); i++) {
			// Getting value of symbol s[i]
			final int s1 = this.value(A.charAt(i));

			// Getting value of symbol s[i+1]
			if ((i + 1) < A.length()) {
				final int s2 = this.value(A.charAt(i + 1));

				// Comparing both values
				if (s1 >= s2) {
					// Value of current symbol is greater
					// or equalto the next symbol
					res = res + s1;
				} else {
					res = (res + s2) - s1;
					i++; // Value of current symbol is
					// less than the next symbol
				}
			} else {
				res = res + s1;
				i++;
			}
		}

		return res;
	}

	int value(final char r) {
		if (r == 'I') {
			return 1;
		}
		if (r == 'V') {
			return 5;
		}
		if (r == 'X') {
			return 10;
		}
		if (r == 'L') {
			return 50;
		}
		if (r == 'C') {
			return 100;
		}
		if (r == 'D') {
			return 500;
		}
		if (r == 'M') {
			return 1000;
		}
		return -1;
	}

	private static final Map<Character, Integer> ct = new HashMap<>();

	static {
		Solutions.ct.put('I', 1);
		Solutions.ct.put('V', 5);
		Solutions.ct.put('X', 10);
		Solutions.ct.put('L', 50);
		Solutions.ct.put('C', 100);
		Solutions.ct.put('D', 500);
		Solutions.ct.put('M', 1000);
	}

	public int romanToInt2(final String A) {
		final Stack<Integer> stack = new Stack<>();

		final int length = A.length();
		for (int i = 0; i < length; i++) {
			final int value = Solutions.ct.get(A.charAt(i));

			if (!stack.isEmpty() && (stack.peek() < value)) {
				final int prev = stack.pop();
				stack.push(value - prev);
			} else {
				stack.push(value);
			}
		}

		int result = 0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;
	}

	public String intToRoman(final int A) {
        final String[] m = {"", "M", "MM", "MMM"};
        final String[] c = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        final String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        final String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

		// Converting to roman
		final String thousands = m[A / 1000];
		final String hundereds = c[(A % 1000) / 100];
		final String tens = x[(A % 100) / 10];
		final String ones = i[A % 10];

		final String ans = thousands + hundereds + tens + ones;

		return ans;
	}

	private static int[] bases = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	private static HashMap<Integer, String> map = new HashMap<>();

	public String intToRoman2(int a) {
		Solutions.setup();
		String result = "";
		for (final int i : Solutions.bases) {
			while (a >= i) {
				result += Solutions.map.get(i);
				a -= i;
			}
		}
		return result;
	}

	private static void setup() {
		Solutions.map.put(1, "I");
		Solutions.map.put(4, "IV");
		Solutions.map.put(5, "V");
		Solutions.map.put(9, "IX");
		Solutions.map.put(10, "X");
		Solutions.map.put(40, "XL");
		Solutions.map.put(50, "L");
		Solutions.map.put(90, "XC");
		Solutions.map.put(100, "C");
		Solutions.map.put(400, "CD");
		Solutions.map.put(500, "D");
		Solutions.map.put(900, "CM");
		Solutions.map.put(1000, "M");
	}

	public String addBinary(final String A, final String B) {
		final BigInteger a = new BigInteger(A, 2);
		final BigInteger b = new BigInteger(B, 2);
		final BigInteger c = a.add(b);
		return c.toString(2);
	}

	public String addBinary2(final String A, final String B) {
		String res = "";
		int i = A.length() - 1;
		int j = B.length() - 1;
		int carry = 0;
		while ((i >= 0) && (j >= 0)) {
			final int d1 = A.charAt(i) - '0';
			final int d2 = B.charAt(j) - '0';
			if ((d1 + d2 + carry) == 0) {
				res = "0" + res;
			} else if ((d1 + d2 + carry) == 1) {
				res = "1" + res;
			} else if ((d1 + d2 + carry) == 2) {
				res = "0" + res;
			} else if ((d1 + d2 + carry) == 3) {
				res = "1" + res;
			}
			carry = (d1 + d2 + carry) / 2;
			i--;
			j--;
		}

		while (i >= 0) {
			final int d1 = A.charAt(i) - '0';
			if ((d1 + carry) == 0) {
				res = "0" + res;
			} else if ((d1 + carry) == 1) {
				res = "1" + res;
			} else if ((d1 + carry) == 2) {
				res = "0" + res;
			}
			carry = (d1 + carry) / 2;
			i--;
		}

		while (j >= 0) {
			final int d2 = B.charAt(j) - '0';
			if ((d2 + carry) == 0) {
				res = "0" + res;
			} else if ((d2 + carry) == 1) {
				res = "1" + res;
			} else if ((d2 + carry) == 2) {
				res = "0" + res;
			}
			carry = (d2 + carry) / 2;
			j--;
		}

		if (carry == 1) {
			res = "1" + res;
		}
		return res;
	}

	public String multiply(final String A, final String B) {
		final int len1 = A.length();
		final int len2 = B.length();
		if ((len1 == 0) || (len2 == 0)) {
			return "0";
		}

		// will keep the result number in vector
		// in reverse order
        final int[] result = new int[len1 + len2];

		// Below two indexes are used to
		// find positions in result.
		int i_n1 = 0;
		int i_n2 = 0;

		// Go from right to left in num1
		for (int i = len1 - 1; i >= 0; i--) {
			int carry = 0;
			final int n1 = A.charAt(i) - '0';

			// To shift position to left after every
			// multipliccharAtion of a digit in num2
			i_n2 = 0;

			// Go from right to left in num2
			for (int j = len2 - 1; j >= 0; j--) {
				// Take current digit of second number
				final int n2 = B.charAt(j) - '0';

				// Multiply with current digit of first number
				// and add result to previously stored result
				// charAt current position.
				final int sum = (n1 * n2) + result[i_n1 + i_n2] + carry;

				// Carry for next itercharAtion
				carry = sum / 10;

				// Store result
				result[i_n1 + i_n2] = sum % 10;

				i_n2++;
			}

			// store carry in next cell
			if (carry > 0) {
				result[i_n1 + i_n2] += carry;
			}

			// To shift position to left after every
			// multipliccharAtion of a digit in num1.
			i_n1++;
		}

		// ignore '0's from the right
		int i = result.length - 1;
		while ((i >= 0) && (result[i] == 0)) {
			i--;
		}

		// If all were '0's - means either both
		// or one of num1 or num2 were '0'
		if (i == -1) {
			return "0";
		}

		// genercharAte the result String
		String s = "";

		while (i >= 0) {
			s += (result[i--]);
		}

		return s;
	}

}
