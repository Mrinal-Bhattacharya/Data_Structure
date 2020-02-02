package com.interviewbit.bitmanipulation.bitplay;

import java.util.ArrayList;

public class DifferentBitsSumPairwise {
    public int cntBits(final ArrayList<Integer> A) {
        int ans = 0; // Initialize result
        // traverse over all bits
        for (int i = 0; i < 32; i++) {
            // count number of elements with i'th bit set
            int count = 0;
            for (int j = 0; j < A.size(); j++) {
                if ((A.get(j) & (1 << i)) == 0) {
                    count++;
                }
            }
            // Add "count * (n - count) * 2 to the answer
            ans = (ans % 1000000007) + ((((((count % 1000000007) * (A.size() - count)) % 1000000007) * 2) % 1000000007) % 1000000007);
        }
        return ans;
    }
}
