package com.interviewbit.hash.search;

import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {
    public int colorful(final int A) {
        final Set<Integer> set = new HashSet<>();
        final String a = String.valueOf(A);

        for (int i = 0; i < a.length(); i++) {
            for (int j = i; j <= a.length(); j++) {
                final String numStr = a.substring(i, j);

                if (numStr.length() > 0) {
                    final int mul = this.findProd(Integer.parseInt(numStr));
                    if (set.contains(mul)) {
                        return 0;
                    }
                    set.add(mul);
                }
            }
        }

        return 1;
    }
    public int findProd(int s) {
        int prd = 1;
        while (s > 0) {
            prd *= s % 10;
            s /= 10;
        }
        return prd;
    }
}
