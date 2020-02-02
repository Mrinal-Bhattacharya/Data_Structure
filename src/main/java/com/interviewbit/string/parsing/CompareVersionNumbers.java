package com.interviewbit.string.parsing;

public class CompareVersionNumbers {
    public int compareVersion(final String A, final String B) {
        final String[] v1 = A.split("\\.");
        final String[] v2 = B.split("\\.");

        final int size = Math.max(v1.length, v2.length);
        int i = 0;
        while (i < size) {
            try {
                final long ver1 = i >= v1.length ? 0 : Long.parseLong(v1[i]);
                final long ver2 = i >= v2.length ? 0 : Long.parseLong(v2[i]);

                if (ver1 > ver2) {
                    return 1;
                }
                if (ver1 < ver2) {
                    return -1;
                }
            } catch (final Exception e) {
                final int r = v1[i].compareTo(v2[i]);
                if (r != 0) {
                    return r > 0 ? 1 : -1;
                }
            }
            i++;
        }

        return 0;
    }
}
