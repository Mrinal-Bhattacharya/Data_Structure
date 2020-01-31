package com.interviewbit.binarysearch.example;

import java.util.List;

public class RotatedArray {
    public int findMin(final List<Integer> a) {
        int low = 0, high = a.size() - 1;
        while (low <= high) {
            if (a.get(low) <= a.get(high)) {
                return a.get(low);
            }
            final int mid = (low + high) / 2;
            final int next = (mid + 1) % a.size();
            final int prev = (mid - 1) % a.size();
            if ((a.get(mid) <= a.get(next)) && (a.get(mid) <= a.get(prev))) {
                return a.get(mid);
            }
            if (a.get(mid) <= a.get(high)) {
                high = mid - 1;
            }
            if (a.get(mid) >= a.get(low)) {
                low = mid + 1;
            }
        }
        return -1;
    }
}
