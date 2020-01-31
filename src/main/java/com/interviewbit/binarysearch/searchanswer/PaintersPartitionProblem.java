package com.interviewbit.binarysearch.searchanswer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PaintersPartitionProblem {
    public int paint(final int painters, final int timeUnit, final ArrayList<Integer> boards) {
        long high = boards.stream().collect(Collectors.summingInt(Integer::intValue));
        long low = boards.stream().max(Comparator.comparing(Integer::valueOf)).get();
        long finalAns = 0;
        while (low <= high) {
            final long mid = (low + high) / 2;
            if (this.isPossible(painters, timeUnit, boards, mid)) {
                finalAns = mid % 10000003;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return (int) ((finalAns * timeUnit) % 10000003);
    }

    private boolean isPossible(final int maxPainters, final int timeUnit, final ArrayList<Integer> boards, final long maxLengthPerPainter) {
        int painters = 1;
        int totalPaint = 0;
        for (int i = 0; i < boards.size(); i++) {
            totalPaint += boards.get(i);
            if (totalPaint > maxLengthPerPainter) {
                totalPaint = boards.get(i);
                painters++;
            }
            if (painters > maxPainters) {
                return false;
            }
        }
        return true;
    }
}
