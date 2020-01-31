package com.interviewbit.graph.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class SteppingNo {

    public static void main(String[] args) {
        new SteppingNo().stepnum(0, 21);
    }

    public ArrayList<Integer> stepNum(int A, int B) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = A; i < B; i++) {
            if (isSteppingNo(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        if (A > B) return res;

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= 9; i++) q.add(i);

        if (A == 0) res.add(0);
        while (!q.isEmpty()) {
            int p = q.poll();
            if (p < B) {
                int last = p % 10;
                if (last > 0) q.add(p * 10 + last - 1);
                if (last < 9) q.add(p * 10 + last + 1);
            }
            if (p >= A && p <= B) res.add(p);
        }
        return res;
    }

    boolean isSteppingNo(int no) {
        if (no == 0) {
            return true;
        }
        int prev = -1;
        int diff_count = 0;
        int temp = no;
        int digit = 0;
        while (temp > 0) {
            digit++;
            temp = temp / 10;
        }
        temp = no;
        while (temp > 0) {
            int curr = temp % 10;
            if (prev != -1) {
                int diff = Math.abs(curr - prev);
                if (diff != 1) {
                    return false;
                }
                else {
                    diff_count++;
                }
            }
            prev = curr;
            temp = temp / 10;
        }
        if (diff_count == digit - 1) {
            return true;
        }
        return false;
    }
}
