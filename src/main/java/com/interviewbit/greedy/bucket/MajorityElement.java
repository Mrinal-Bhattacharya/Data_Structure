package com.interviewbit.greedy.bucket;

import java.util.Collections;
import java.util.List;

public class MajorityElement {
    public int majorityElement(final List<Integer> A) {
        int maj = A.get(0);
        int count = 1;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) == maj) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                maj = A.get(i);
                count = 1;
            }
        }
        return maj;
    }

    public int majorityElement1(final List<Integer> A) {
        Collections.sort(A);
        return A.get(A.size() / 2);
    }
}
