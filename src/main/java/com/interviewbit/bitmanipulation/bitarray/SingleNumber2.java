package com.interviewbit.bitmanipulation.bitarray;

import java.util.List;

public class SingleNumber2 {
    public int singleNumber(final List<Integer> A) {
        int result = 0;
        int x, sum;
        int n = A.size();

        // Iterate through every bit
        for (int i = 0; i < 32; i++) {
            // Find sum of set bits at ith position in all
            // array elements
            sum = 0;
            x = (1 << i);
            for (int j = 0; j < n; j++) {
                if ((A.get(j) & x) == 0) sum++;
            }
            // The bits with sum not multiple of 3, are the
            // bits of element with single occurrence.
            if ((sum % 3) == 0) result |= x;
        }
        return result;
    }
}
