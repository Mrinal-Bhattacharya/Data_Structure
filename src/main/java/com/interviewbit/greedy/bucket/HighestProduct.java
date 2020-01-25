package com.interviewbit.greedy.bucket;

import java.util.ArrayList;
import java.util.Collections;

public class HighestProduct {
    public int maxp3(final ArrayList<Integer> a) {
        Collections.sort(a);
        final int n = a.size();
        return Math.max((a.get(n - 1) * a.get(n - 2) * a.get(n - 3)), (a.get(n - 1) * a.get(0) * a.get(1)));
    }

}
