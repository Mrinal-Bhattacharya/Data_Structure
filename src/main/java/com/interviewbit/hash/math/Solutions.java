package com.interviewbit.hash.math;

import java.util.HashMap;
import java.util.Map;

public class Solutions {
	public String fractionToDecimal(final int A, final int B) {
		if (A == 0) {
			return "0";
		}
		if (B == 0) {
			return "";
		}
		final HashMap<Long, Integer> map = new HashMap<>();
		String result = "";
		if (((A < 0) && (B > 0)) || ((A > 0) && (B < 0))) {
			result += "-";
		}
		long numerator = A;
		long denominator = B;
		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);

		long res = numerator / denominator;
		result += String.valueOf(res);
		System.out.println(numerator % denominator);
		long remainder = (numerator % denominator) * 10;
		if (remainder == 0) {
			return result;
		}
		result += '.';

		while (remainder != 0) {
			// System.out.println("remainder : " + remainder);
			if (map.containsKey(remainder)) {
				final int beg = map.get(remainder);
				final String part1 = result.substring(0, beg);
				final String part2 = result.substring(beg, result.length());
				result = part1 + "(" + part2 + ")";
				return result;
			}
			map.put(remainder, result.length());
			res = remainder / denominator;
			result += String.valueOf(res);
			remainder = (remainder % denominator) * 10;
		}

		return result;
	}

	public String fractionToDecimal2(final int numerator, final int denominator) {
		long a = numerator, b = denominator;
		if ((a % b) == 0) {
			return String.valueOf(a / b);
		}
		final Map<Long, Integer> map = new HashMap<>();
		final StringBuilder res = new StringBuilder();
		if (((a > 0) && (b < 0)) || ((a < 0) && (b > 0))) {
			res.append("-");
		}
		a = Math.abs(a);
		b = Math.abs(b);
		res.append((a / b) + ".");
		a = (a % b) * 10;
		while (!map.containsKey(a)) {
			map.put(a, res.length());
			res.append(String.valueOf(a / b));
			a = (a % b) * 10;
			if (a == 0) {
				return res.toString();
			}
		}
		return res.insert(map.get(a), "(").append(")").toString();
	}

	public static void main(final String[] args) {
		System.out.println(new Solutions().fractionToDecimal(2, 3));
	}
}
