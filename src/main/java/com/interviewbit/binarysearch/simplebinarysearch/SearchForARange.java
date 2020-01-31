package com.interviewbit.binarysearch.simplebinarysearch;

import java.util.ArrayList;
import java.util.List;

public class SearchForARange {
    public ArrayList<Integer> searchRange(final List<Integer> a, final int b) {
        final ArrayList<Integer> result = new ArrayList<>();
        result.add(this.binarySearch(a, b, true));
        result.add(this.binarySearch(a, b, false));
        return result;
    }

    int binarySearch(final List<Integer> A, final int B, final boolean searchFirst) {
        int result = -1, low = 0, high = A.size() - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (A.get(mid) == B) {
                result = mid;
                if (searchFirst == true) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else if (B < A.get(mid)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return result;
    }
}
