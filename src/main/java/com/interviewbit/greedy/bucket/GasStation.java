package com.interviewbit.greedy.bucket;

import java.util.List;

public class GasStation {
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int n = A.size();

        int sumRemaining = 0;
        int total = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            int remaining = A.get(i) - B.get(i);
            if (sumRemaining >= 0) sumRemaining += remaining;
            else {
                sumRemaining = remaining;
                start = i;
            }
            total += remaining;
        }

        if (total >= 0) return start;
        else return -1;
    }
}
