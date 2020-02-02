package com.interviewbit.string.simulation;

public class CountAndSay {
    public String countAndSay(final int A) {
        StringBuilder builder = new StringBuilder();
        final String s1 = "1";
        if (A <= 1) {
            return s1;
        }
        String temp = s1;
        int j;
        for (int i = 2; i <= A; i++) {
            for (j = 0; j < temp.length(); j++) {
                int count = 1;
                final char ts = temp.charAt(j);
                while ((j < (temp.length() - 1)) && (temp.charAt(j) == temp.charAt(j + 1))) {
                    count++;
                    j++;
                }
                builder.append(count);
                builder.append(ts);
            }
            temp = builder.toString();
            builder = new StringBuilder();
        }
        return temp;
    }
}
