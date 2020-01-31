package com.interviewbit.graph.shortestpath;

import java.util.ArrayList;

public class SumOfFibonacciNumbers {
    public int fibsum(int A) {
        int a = 0;
        int b = 1;
        int c = -1;
        ArrayList<Integer> fibNums = new ArrayList<Integer>();
        fibNums.add(1);
        fibNums.add(1);
        while (true) {
            c = a + b;
            if (c <= A) fibNums.add(c);
            else break;

            a = b;
            b = c;
        }
        int count = 0;
        int num = A;
        int index = fibNums.size() - 1;
        while (num > 0) {
            int fib = fibNums.get(index);
            if (num >= fib) {
                count += (num / fib);
                num %= fib;
            }
            index--;
        }
        return count;
    }
}
