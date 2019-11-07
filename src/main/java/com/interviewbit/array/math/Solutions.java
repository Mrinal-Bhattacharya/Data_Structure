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
