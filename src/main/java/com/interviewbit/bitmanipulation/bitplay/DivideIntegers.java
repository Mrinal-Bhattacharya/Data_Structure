package com.interviewbit.bitmanipulation.bitplay;

public class DivideIntegers {
    public int divide(int A, int B) {
        if ((A == Integer.MIN_VALUE) && (B == -1)) {
            return Integer.MAX_VALUE;
        }
        int ans = 0;
        int check = 1;
        if (A < 0) {
            check *= -1;
        }
        if (B < 0) {
            check *= -1;
        }
        A = Math.abs(A);
        B = Math.abs(B);
        while ((A - B) >= 0) {
            A -= B;
            ans++;
        }
        return ans * check;
    }
}
