package com.interviewbit.binarysearch.searchanswer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AllocateBooks {
    public static void main(final String[] args) {
        final Integer[] arg0 = {97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53, 8, 44, 68, 90, 24};
        System.out.println(new AllocateBooks().books(Arrays.asList(arg0), 26));
    }

    public int books(final List<Integer> A, final int B) {
        if (B > A.size()) {
            return -1;
        }
        final long total_pages = A.stream().collect(Collectors.summingInt(Integer::intValue));
        long s = A.stream().max(Comparator.comparing(Integer::valueOf)).get();
        long e = total_pages;
        long finalAns = 0;
        while (s <= e) {
            final long mid = (s + e) / 2;
            if (this.isValidConfig(A, B, mid)) {
                finalAns = mid;
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }
        return (int) finalAns;
    }

    private boolean isValidConfig(final List<Integer> books, final int totalStudents, final long ans) {
        int students = 1;
        long currentpages = 0;
        for (int i = 0; i < books.size(); i++) {
            currentpages += books.get(i);
            if (currentpages > ans) {
                currentpages = books.get(i);
                students++;
            }
            if (students > totalStudents) {
                return false;
            }
        }
        return true;
    }
}
