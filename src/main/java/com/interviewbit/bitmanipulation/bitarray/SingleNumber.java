package com.interviewbit.bitmanipulation.bitarray;

import java.util.List;

public class SingleNumber {
    public int singleNumber(final List<Integer> A) {
        int n = 0;
        for (int x : A) {
            n ^= x;
        }
        return n;
    }

}
