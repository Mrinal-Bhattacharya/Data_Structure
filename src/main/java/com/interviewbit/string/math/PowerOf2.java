package com.interviewbit.string.math;

import java.math.BigInteger;

public class PowerOf2 {
    public int power(String A) {
        BigInteger bi = new BigInteger(A);
        if (bi.equals(BigInteger.ONE)) return 0;
        if (bi.equals(BigInteger.ZERO)) return 0;

        while (bi.remainder(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            bi = bi.divide(BigInteger.valueOf(2));
        }

        if (bi.equals(BigInteger.ONE)) return 1;
        return 0;
    }
}
