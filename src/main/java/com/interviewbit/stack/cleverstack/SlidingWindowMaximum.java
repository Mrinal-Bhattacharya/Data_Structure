package com.interviewbit.stack.cleverstack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
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
