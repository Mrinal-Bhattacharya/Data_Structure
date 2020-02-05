package com.interviewbit.backtracking.bruteforcebuilder;

import java.util.ArrayList;

public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(final String a) {
        final ArrayList<ArrayList<String>> ans = new ArrayList<>();
        this.partitionHelper(ans, new ArrayList<String>(), a, 0);
        return ans;
    }

    private void partitionHelper(final ArrayList<ArrayList<String>> ans, final ArrayList<String> temp, final String a,
                                 final int idx) {
        if (idx == a.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < a.length(); i++) {
            final String sb = a.substring(idx, i + 1);

            if (this.isPalindrome(sb)) {
                temp.add(sb);
                this.partitionHelper(ans, temp, a, i + 1);
                temp.remove(temp.size() - 1);
            }
        }

    }

    private boolean isPalindrome(final String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
