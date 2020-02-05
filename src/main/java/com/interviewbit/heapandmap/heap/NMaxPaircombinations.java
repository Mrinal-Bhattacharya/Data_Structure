package com.interviewbit.heapandmap.heap;

import java.util.*;

public class NMaxPaircombinations {
    public ArrayList<Integer> solve(final ArrayList<Integer> A, final ArrayList<Integer> B) {
        int n = A.size();
        final PriorityQueue<SumElement> pq = new PriorityQueue<>(new Comparator<SumElement>() {
            @Override
            public int compare(final SumElement o1, final SumElement o2) {
                return o2.sum - o1.sum;
            }
        });

        Collections.sort(A);
        Collections.sort(B);
        pq.add(new SumElement(A.get(n - 1) + B.get(n - 1), n - 1, n - 1));
        final ArrayList<Integer> ans = new ArrayList<>();
        final Set<String> set = new HashSet<>();
        set.add((n - 1) + "|" + (n - 1));
        while (n-- > 0) {
            final SumElement element = pq.poll();
            ans.add(element.sum);
            if (!set.contains((element.ind1 - 1) + "|" + (element.ind2))) {
                if ((element.ind1 - 1) >= 0) {
                    pq.add(new SumElement(A.get(element.ind1 - 1) + B.get(element.ind2), element.ind1 - 1,
                            element.ind2));
                    set.add((element.ind1 - 1) + "|" + (element.ind2));
                }
            }

            if (!set.contains((element.ind1) + "|" + (element.ind2 - 1))) {
                if ((element.ind2 - 1) >= 0) {
                    pq.add(new SumElement(A.get(element.ind1) + B.get(element.ind2 - 1), element.ind1,
                            element.ind2 - 1));
                    set.add((element.ind1) + "|" + (element.ind2 - 1));
                }
            }
        }

        return ans;
    }


}



