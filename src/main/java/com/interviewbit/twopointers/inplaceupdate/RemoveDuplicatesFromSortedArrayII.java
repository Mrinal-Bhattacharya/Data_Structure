package com.interviewbit.twopointers.inplaceupdate;

import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates2(final ArrayList<Integer> a) {
        if (a.size() <= 1) {
            return a.size();
        }
        int i = 1;
        int j = 1;
        boolean twice = false;

        while (i < a.size()) {
            if (!a.get(i).equals(a.get(i - 1))) {
                a.set(j, a.get(i));
                j++;
                twice = false;
            } else {
                if (!twice) {
                    a.set(j, a.get(i));
                    twice = true;
                    j++;
                }
            }
            i++;
        }

        final ArrayList<Integer> itemsToKeep = new ArrayList<>();
        i = 0;
        while (i < j) {
            itemsToKeep.add(a.get(i++));
        }

        a.clear();
        for (final int num : itemsToKeep) {
            a.add(num);
        }

        return a.size();
    }
}
