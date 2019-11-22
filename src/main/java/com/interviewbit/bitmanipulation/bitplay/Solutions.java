package com.interviewbit.bitmanipulation.bitplay;

import java.util.ArrayList;
import java.util.List;

public class Solutions {
	public int numSetBits(long a) {
		int count = 0;
		while (a > 0) {
			count += a & 1;
			a >>= 1;
		}
		return count;
	}

	public long reverse(final long A) {
		long rev = 0;

		for (int i = 0; i < 32; i++) {
			rev <<= 1;
			if ((A & (1 << i)) != 0) {
				rev |= 1;
			}
		}

		return rev;

	}

	public boolean checkKthBit(final long A, final int k) {
		final long c = A & (1 << (k - 1));
		if (c != 0) {
			return true;
		}
		return false;
	}

	public long setKthBit(final long A, final int k) {
		return A | (1 << (k - 1));
	}

	public long clearKBit(final int A, final int k) {
		return A & (~(1 << (k - 1)));
	}

	public long toggleKBit(final int A, final int k) {
		return A ^ (1 << (k - 1));
	}

	public int divide(int A, int B) {
		if ((A == Integer.MIN_VALUE) && (B == -1)) {
			return Integer.MAX_VALUE;
		}
		int ans = 0;
		int check = 1;
		if (A < 0) {
			check *= -1;
		}
		if (B < 0) {
			check *= -1;
		}
		A = Math.abs(A);
		B = Math.abs(B);
		while ((A - B) >= 0) {
			A -= B;
			ans++;
		}
		return ans * check;
	}

	// Mod is for interviewbit otherwise we don't need % 1000000007
	public int cntBits(final ArrayList<Integer> A) {
		int ans = 0; // Initialize result

		// traverse over all bits
		for (int i = 0; i < 32; i++) {

			// count number of elements
			// with i'th bit set
			int count = 0;

			for (int j = 0; j < A.size(); j++) {
				if ((A.get(j) & (1 << i)) == 0) {
					count++;
				}
			}

			// Add "count * (n - count) * 2"
			// to the answer
			ans = (ans % 1000000007)
					+ ((((((count % 1000000007) * (A.size() - count)) % 1000000007) * 2) % 1000000007) % 1000000007);
		}

		return ans;
	}

	public int singleNumber(final List<Integer> A) {
		int n = 0;
		for (final int x : A) {
			n ^= x;
		}
		return n;
	}

	// A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
	// Output= 4
	public int singleNumber2(final List<Integer> A) {
		int result = 0;
		int x, sum;
		final int n = A.size();

		// Iterate through every bit
		for (int i = 0; i < 32; i++) {
			// Find sum of set bits at ith position in all
			// array elements
			sum = 0;
			x = (1 << i);
			for (int j = 0; j < n; j++) {
				if ((A.get(j) & x) == 0) {
					sum++;
				}
			}
			// The bits with sum not multiple of 3, are the
			// bits of element with single occurrence.
			if ((sum % 3) == 0) {
				result |= x;
			}
		}
		return result;
	}
}
