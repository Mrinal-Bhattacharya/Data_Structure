package com.interviewbit.array.math;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Solutions {

	void plusOne(final ArrayList<Integer> a) {
		final int n = a.size();

		// Add 1 to last digit and find carry
		a.set(n - 1, a.get(n - 1) + 1);
		int carry = a.get(n - 1) / 10;
		a.set(n - 1, a.get(n - 1) % 10);

		// Traverse from second last digit
		for (int i = n - 2; i >= 0; i--) {
			if (carry == 1) {
				a.set(i, a.get(i) + 1);
				carry = a.get(i) / 10;
				a.set(i, a.get(i) % 10);
			}
		}

		// If carry is 1, we need to add
		// a 1 at the beginning of vector
		if (carry == 1) {
			a.add(0, 1);
		}
		final ListIterator<Integer> listIterator = a.listIterator();
		while (listIterator.hasNext()) {
			if (listIterator.next() == 0) {
				listIterator.remove();
			}
			break;
		}
	}

	public ArrayList<Integer> plusOneInterviewBit(final ArrayList<Integer> a) {
		int i = 0;
		// remove zeroes at the front
		while ((i < (a.size() - 1)) && (a.get(i) == 0)) {
			a.remove(i);
		}

		int carry = 1;
		int sum;
		for (i = a.size() - 1; i >= 0; i--) {
			sum = a.get(i) + carry;
			a.set(i, sum % 10);
			carry = sum / 10;
			// no need of further processing if carry is zero
			if (carry == 0) {
				break;
			}
		}
		// if carry is still left
		if (carry != 0) {
			a.add(0, carry);
		}
		return a;
	}

	public int maxSubArray(final List<Integer> A) {
		int maxEndingHere = A.get(0);
		int maxSoFar = A.get(0);
		for (int i = 1; i < A.size(); i++) {
			maxEndingHere = Math.max(A.get(i), A.get(i) + maxEndingHere);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}

	public int maxArr(final ArrayList<Integer> A) {
		int result = 0;
		// Iterate through all pairs.
		for (int i = 0; i < A.size(); i++) {
			for (int j = i; j < A.size(); j++) {
				result = Math.max(result, Math.abs(A.get(i) - A.get(j)) + Math.abs(i - j));
			}
		}
		return result;
	}

	/*
	 * f(i, j) = |A[i] - A[j]| + |i - j| can be written in 4 ways (Since we are
	 * looking at max value, we don’t even care if the value becomes negative as
	 * long as we are also covering the max value in some way).
	 *
	 * (A[i] + i) - (A[j] + j) -(A[i] - i) + (A[j] - j) (A[i] - i) - (A[j] - j)
	 * (-A[i] - i) + (A[j] + j) = -(A[i] + i) + (A[j] + j)
	 *
	 * Note that case 1 and 4 are equivalent and so are case 2 and 3.
	 *
	 * We can construct two arrays with values: A[i] + i and A[i] - i. Then, for
	 * above 2 cases, we find the maximum value possible. For that, we just have to
	 * store minimum and maximum values of expressions A[i] + i and A[i] - i for all
	 */
	public int maxArrInterviewBit(final ArrayList<Integer> A) {
		int max1 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE;
		int max2 = Integer.MIN_VALUE;
		int min2 = Integer.MAX_VALUE;

		for (int i = 0; i < A.size(); i++) {

			// Updating max and min variables
			// as described in algorithm.
			max1 = Math.max(max1, A.get(i) + i);
			min1 = Math.min(min1, A.get(i) + i);
			max2 = Math.max(max2, A.get(i) - i);
			min2 = Math.min(min2, A.get(i) - i);
		}

		// Calculating maximum absolute difference.
		return Math.max(max1 - min1, max2 - min2);
	}

	public ArrayList<Integer> repeatedNumber(final List<Integer> copy) {
		final List<Integer> A = new ArrayList<>();
		A.addAll(copy);
		final ArrayList<Integer> out = new ArrayList<>();
		for (int i = 0; i < A.size(); i++) {
			final int abs = Math.abs(A.get(i));
			if (A.get(abs - 1) > 0) {
				A.set(abs - 1, -A.get(abs - 1));
			} else {
				out.add(abs);
			}
		}
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) > 0) {
				out.add(i + 1);
			}
		}
		return out;
	}

	// Driver code
	public static void main(final String[] args) {
		final ArrayList<Integer> vect = new ArrayList<>();
		vect.add(0);
		vect.add(7);
		vect.add(8);
		vect.add(9);

		new Solutions().plusOne(vect);

		for (int i = 0; i < vect.size(); i++) {
			System.out.print(vect.get(i) + " ");
		}
	}
}
