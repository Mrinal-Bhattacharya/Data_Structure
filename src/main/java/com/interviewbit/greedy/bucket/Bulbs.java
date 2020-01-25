package com.interviewbit.greedy.bucket;

import java.util.ArrayList;

public class Bulbs {

    public int bulbs(final ArrayList<Integer> A) {
        int state = 0;
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            if (state == A.get(i)) {
                count++;
                state = 1 - state;
            }
        }

        return count;
    }

    public static int bulbs2(final ArrayList<Integer> A) {
        int switchCount = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0) {
                switchCount++;
                for (int j = i; j < A.size(); j++) {
                    if (A.get(j) == 0) {
                        A.set(j, 1);
                    } else {
                        A.set(j, 0);
                    }
                }
            }
        }
        return switchCount;
    }
}
