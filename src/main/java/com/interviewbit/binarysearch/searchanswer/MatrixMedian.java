package com.interviewbit.binarysearch.searchanswer;

import java.util.ArrayList;
import java.util.List;

public class MatrixMedian {
    private int countSmaller(final List<Integer> A, int B) {
        int left = 0, right = A.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (B <= A.get(mid)) right = mid - 1;
            else // if B > A.get(mid)
                left = mid + 1;
        }
        return left;
    }

    private int countSmaller(ArrayList<ArrayList<Integer>> A, int B) {
        int smaller = 0;
        for (int i = 0; i < A.size(); i++) {
            smaller += countSmaller(A.get(i), B);
        }
        return smaller;
    }

    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (int) (left + ((long) right - left) / 2);
            int total = A.size() * A.get(0).size();
            int smaller = countSmaller(A, mid);
            if (smaller > total / 2) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }
}
