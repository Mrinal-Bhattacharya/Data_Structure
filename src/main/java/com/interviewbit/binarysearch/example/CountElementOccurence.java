package com.interviewbit.binarysearch.example;

import java.util.List;

public class CountElementOccurence {
    public int findCount(final List<Integer> A, int B) {
        final int first = this.binarySearch(A, B, true);
        final int last = this.binarySearch(A, B, false);
        if (last == -1) {
            return 0;
        }
        return (last - first) + 1;
    }

    int binarySearch(final List<Integer> A, int B, boolean searchFirst) {
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
