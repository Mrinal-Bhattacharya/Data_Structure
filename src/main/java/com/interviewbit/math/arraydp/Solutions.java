package com.interviewbit.math.arraydp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solutions {

	public int solve(final ArrayList<Integer> A, int B, final int C) {
		int base = 10;

		final List<Integer> values = new ArrayList<>();
		if (B == 1) {
			base = 0;
			B = 10;
		} else {
			base = (int) Math.pow(10, B - 1);
			B = (int) Math.pow(10, B);
		}
		for (int i = base; (i < C) && (i < B); i++) {
			boolean flag = true;
			int num = i;
			if ((num == 0) && !A.contains(num)) {
				continue;
			}
			while (num != 0) {
				if (!A.contains(num % 10)) {
					flag = false;
					break;
				}
				num /= 10;
			}
			if (flag == true) {
				values.add(i);
			}
		}
		return values.size();
	}

	ArrayList<Integer> numToVec(int N) {
		final ArrayList<Integer> digit = new ArrayList<>();

		// Push all the digits of N from the end
		// one by one to the vector
		while (N != 0) {
			digit.add(N % 10);
			N = N / 10;
		}

		// If the original number was 0
		if (digit.size() == 0) {
			digit.add(0);
		}

		// Reverse the vector elements
		Collections.reverse(digit);

		// Return the required vector
		return digit;
	}

	// Function to return the count
	// of B length integers which are
	// less than C and they contain
	// digits from set A[] only
	int solve2(final ArrayList<Integer> A, final int B, final int C) {
		final int MAX = 10;

		ArrayList<Integer> digit = new ArrayList<>();
		int d2;

		// Convert number to digit array
		digit = this.numToVec(C);
		final int d = A.size();

		// Case 1: No such number possible as the
		// generated numbers will always
		// be greater than C
		if ((B > digit.size()) || (d == 0)) {
			return 0;
		} else if (B < digit.size()) {
			// contain 0
			if ((A.get(0) == 0) && (B != 1)) {
				return (int) ((d - 1) * Math.pow(d, B - 1));
			} else {
				return (int) Math.pow(d, B);
			}
		}

		// Case 3
		else {
			final int[] dp = new int[B + 1];
			final int[] lower = new int[MAX + 1];

			// Update the lower[] array such that
			// lower[i] stores the count of elements
			// in A[] which are less than i
			for (int i = 0; i < d; i++) {
				lower[A.get(i) + 1] = 1;
			}
			for (int i = 1; i <= MAX; i++) {
				lower[i] = lower[i - 1] + lower[i];
			}

			boolean flag = true;
			dp[0] = 0;
			for (int i = 1; i <= B; i++) {
				d2 = lower[digit.get(i - 1)];
				dp[i] = dp[i - 1] * d;

				// For first index we can't use 0
				if ((i == 1) && (A.get(0) == 0) && (B != 1)) {
					d2 = d2 - 1;
				}

				// Whether (i-1) digit of generated number
				// can be equal to (i - 1) digit of C
				if (flag) {
					dp[i] += d2;
				}

				// Is digit[i - 1] present in A ?
				flag = (flag & (lower[digit.get(i - 1) + 1] == (lower[digit.get(i - 1)] + 1)));
			}
			return dp[B];
		}
	}

	public static void main(final String[] args) {
		final ArrayList<Integer> A = new ArrayList<>();
		A.add(0);
		A.add(3);
		A.add(1);
		A.add(6);
		A.add(7);
		A.add(4);
		System.out.println(new Solutions().solve(A, 4, 59172));
	}
}
