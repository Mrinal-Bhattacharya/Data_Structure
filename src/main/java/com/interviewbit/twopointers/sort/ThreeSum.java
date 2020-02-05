package com.interviewbit.twopointers.sort;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSum {
    public int threeSumClosest(final ArrayList<Integer> A, final int B) {
        int low, high, mid;
        Collections.sort(A);
        final int n = A.size();
        int res = A.get(0) + A.get(1) + A.get(2);

        if (n == 3) {
            return res;
        }
        int sum;
        for (low = 0; low < (n - 2); low++) {
            mid = low + 1;
            high = n - 1;
            final int num = B - A.get(low);
            while (mid < high) {
                sum = A.get(mid) + A.get(high);
                if (sum == num) {
                    return B;
                } else if (sum < num) {
                    mid++;
                } else {
                    high--;
                }
                final int diff = Math.abs(sum - num);
                final int otherDiff = Math.abs(res - B);
                if (diff < otherDiff) {
                    res = sum + A.get(low);
                }
            }
        }
        return res;
    }
}
