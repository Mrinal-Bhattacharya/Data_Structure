package com.interviewbit.twopointers.tricks;

import java.util.ArrayList;

public class ContainerWithMostWater {
    int maxArea2(final ArrayList<Integer> A) {
        int maxArea = 0; // Initializing maximum area as 0

        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                // Going through all pairs (i,j) for maximum container area.
                maxArea = Math.max(maxArea, Math.min(A.get(i), A.get(j)) * (j - i));
            }
        }
        return maxArea;
    }

    public int maxArea(final ArrayList<Integer> A) {
        int l = 0;
        int r = A.size() - 1;
        int area = 0;

        while (l < r) {
            // Calculating the max area
            area = Math.max(area, Math.min(A.get(l), A.get(r)) * (r - l));

            if (A.get(l) < A.get(r)) {
                l++;
            } else {
                r--;
            }
        }
        return area;
    }
}
