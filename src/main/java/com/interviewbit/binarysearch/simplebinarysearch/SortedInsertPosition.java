package com.interviewbit.binarysearch.simplebinarysearch;

import java.util.ArrayList;
import java.util.List;

public class SortedInsertPosition {
    public int searchInsert2(final List<Integer> a, final int target) {
        int low = 0, high = a.size() - 1;
        if (a.get(low) > target) {
            return low;
        }
        if (a.get(high) < target) {
            return high + 1;
        }
        while (low <= high) {
            final int mid = low + ((high - low) / 2);
            if (a.get(mid) == target) {
                return mid;
            }
            if (target > a.get(mid)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int searchInsert(ArrayList<Integer> a, int b) {
        final int n = a.size();
        int low = 0, high = n - 1;
        int mid = low + ((high - low) / 2);
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if ((a.get(mid) == b) || ((mid == 0) && (b < a.get(mid))) || ((mid > 0) && (b < a.get(mid)))) {
                return mid;
            }
            if (b > a.get(mid)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return n;
    }
}
