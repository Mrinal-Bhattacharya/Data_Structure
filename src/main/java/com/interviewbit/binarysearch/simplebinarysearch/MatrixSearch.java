package com.interviewbit.binarysearch.simplebinarysearch;

import java.util.ArrayList;

public class MatrixSearch {
    public int searchMatrix(final ArrayList<ArrayList<Integer>> a, final int b) {
        int row = 0, column = a.get(0).size() - 1; // set indexes for top right
        // element

        while ((row < a.size()) && (column >= 0)) {
            if (a.get(row).get(column) == b) {
                return 1;
            }
            if (a.get(row).get(column) > b) {
                column--;
            }
            else {
                row++;
            }
        }

        return 0;
    }
}
