package com.interviewbit.heapandmap.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MagicianAndChocolates {
    public int nchoc(int A, final ArrayList<Integer> B) {
        final int MOD = 1000000007;
        final PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(final Integer o1, final Integer o2) {
                return o2 - o1;
            }
        });

        for (final Integer choc : B) {
            pq.add(choc);
        }

        long total = 0;

        while (A-- > 0) {
            final int choc = pq.poll();
            total += choc;
            total %= MOD;
            pq.add(choc / 2);
        }

        return (int) total;
    }
}
