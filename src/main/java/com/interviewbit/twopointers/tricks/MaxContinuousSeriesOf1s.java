package com.interviewbit.twopointers.tricks;

import java.util.ArrayList;

public class MaxContinuousSeriesOf1s {
    public ArrayList<Integer> maxone(final ArrayList<Integer> A, final int B) {
        final ArrayList<Integer> result = new ArrayList<>();
        int wL = 0;
        int wR = 0;
        int nZero = 0;
        int bL = 0, bR = 0, bW = -1;
        while (wR < A.size()) {
            if (nZero <= B) {
                if (A.get(wR) == 0) {
                    nZero++;
                }
                wR++;
            }
            if (nZero > B) {
                if (A.get(wL) == 0) {
                    nZero--;
                }
                wL++;
            }
            if (((wR - wL)) > bW) {
                bW = wR - wL;
                bR = wR;
                bL = wL;
            }
        }
        for (int i = bL; i < bR; i++) {
            result.add(i);
        }
        return result;
    }
}
