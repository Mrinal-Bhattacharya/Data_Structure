package com.interviewbit.stack.cleverstack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solutions {
	public ArrayList<Integer> prevSmaller(final ArrayList<Integer> A) {
		final ArrayList<Integer> ans = new ArrayList<>();
		final Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < A.size(); i++) {
			while (!stack.isEmpty() && (stack.peek() >= A.get(i))) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				ans.add(-1);
			} else {
				ans.add(stack.peek());
			}

			stack.push(A.get(i));
		}

		return ans;
	}

	public int largestRectangleArea(final ArrayList<Integer> A) {
		if ((null == A) || A.isEmpty()) {
			return 0;
		}
		if (A.size() == 1) {
			return A.get(0);
		}
		int max = 0;
		final Stack<Integer> stack = new Stack<>();
		int i = 0;
		while (i < A.size()) {
			if (stack.isEmpty() || (A.get(stack.peek()) <= A.get(i))) {
				stack.push(i);
				i++;
			} else {
				final int top = stack.pop();
				final int height = A.get(top);
				final int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
				max = Math.max(max, height * width);
			}
		}
		while (!stack.isEmpty()) {
			final int top = stack.pop();
			final int height = A.get(top);
			final int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
			max = Math.max(max, height * width);
		}
		return max;
	}

	public int largestRectangleArea2(final ArrayList<Integer> A) {
		int max_rectangle = 0;
		for (int i = 0; i < A.size(); i++) {
			final int H = A.get(i);
			int L = i;
			int R = i;
			while ((L >= 0) && (A.get(L) >= H)) {
				L = L - 1;
			}
			while ((R < A.size()) && (A.get(R) >= H)) {
				R = R + 1;
			}
			max_rectangle = Math.max(max_rectangle, (R - L - 1) * H);
		}
		return max_rectangle;
	}

	public ArrayList<Integer> slidingMaximum(final List<Integer> a, final int b) {
		final ArrayList<Integer> result = new ArrayList<>();
		if ((a == null) || (a.size() == 0)) {
			return result;
		}
		if (b > a.size()) {
			result.add(this.max(a, 0, a.size() - 1));
			return result;
		}
		for (int i = 0; i <= (a.size() - b); i++) {
			result.add(this.max(a, i, (i + b) - 1));
		}
		return result;
	}

	public int max(final List<Integer> a, final int start, final int end) {
		int maximum = a.get(start);
		for (int i = start + 1; i <= end; i++) {
			if (a.get(i) > maximum) {
				maximum = a.get(i);
			}
		}
		return maximum;
	}

	public ArrayList<Integer> slidingMaximum2(final List<Integer> A, final int B) {
		final Deque<Integer> window = new LinkedList<>();
		final ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < A.size(); i++) {
			final int val = A.get(i);
			// Remove all elements smaller than the current one from the queue
			while (!window.isEmpty() && (val >= A.get(window.getLast()))) {
				window.removeLast();
			}
			// Add the current element's index to the queue. It is important that we
			// store the indicies rather than the values.
			window.add(i);
			// The first element of the queue is always the largest. If the index of
			// this number is smaller than the window's stating index then we remove it
			if (window.getFirst() < ((i + 1) - B)) {
				window.removeFirst();
			}
			// Ignores the first few interations
			if (i >= (B - 1)) {
				result.add(A.get(window.getFirst()));
			}
		}
		return result;
	}
}
