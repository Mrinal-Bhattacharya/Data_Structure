package com.interviewbit.binarysearch.searchanswer;

public class SquareRootOfInteger {
    public int sqrt(final int a) {
        int low = 0;
        int high = a;
        int result = 0;
        while (low <= high) {
            final int mid = low + (high / 2);
            if ((mid * mid) == a) {
                return mid;
            }
            if ((mid * mid) < a) {
                result = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return result;
    }
}
