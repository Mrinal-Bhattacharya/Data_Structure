package com.interviewbit.bitmanipulation.bitplay;

public class KBitManipulation {
    public boolean checkKthBit(final long A, final int k) {
        final long c = A & (1 << (k - 1));
        return c != 0;
    }

    public long setKthBit(final long A, final int k) {
        return A | (1 << (k - 1));
    }

    public long clearKBit(final int A, final int k) {
        return A & (~(1 << (k - 1)));
    }

    public long toggleKBit(final int A, final int k) {
        return A ^ (1 << (k - 1));
    }
}
