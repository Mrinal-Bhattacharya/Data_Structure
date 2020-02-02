package com.interviewbit.string.tricks;

public class MinimuCharactersRequiredToMakeAStringPalindromic {
    public boolean isPalindrom(final String input) {
        int i = 0;
        int j = input.length() - 1;
        while ((i < j) && (input.charAt(i) == input.charAt(j))) {
            i++;
            j--;
        }
        return i >= j;
    }

    public int solveMinCharPalindrom(String A) {
        int cnt = 0;
        while (A.length() > 0) {
            // if string becomes palindrome then break
            if (this.isPalindrom(A)) {
                break;
            }
            else {
                cnt++;
                // erase the last element of the string
                A = A.substring(0, A.length() - 1);
                // s.erase(s.begin() + s.length() - 1);
            }
        }

        return cnt;
    }
}
