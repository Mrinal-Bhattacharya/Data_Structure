package com.interviewbit.string.prettyprint;

import java.util.ArrayList;

public class JustifiedText {
    public ArrayList<String> fullJustify(final ArrayList<String> a, final int b) {
        final ArrayList<String> res = new ArrayList<>();
        final int n = a.size();
        int index = 0;
        while (index < n) {
            int totalChars = a.get(index).length();
            int last = index + 1;
            while (last < n) {
                if ((totalChars + 1 + a.get(last).length()) > b) {
                    break;
                }
                totalChars += 1 + a.get(last).length();
                last++;
            }
            final int gaps = last - index - 1;
            final StringBuilder builder = new StringBuilder();
            if ((last == n) || (gaps == 0)) {
                for (int i = index; i < last; i++) {
                    builder.append(a.get(i));
                    builder.append(" ");
                }
                builder.deleteCharAt(builder.length() - 1);
                while (builder.length() < b) {
                    builder.append(" ");
                }
            }
            else if (totalChars == b) {
                for (int i = index; i < (last - 1); i++) {
                    builder.append(a.get(i));
                    builder.append(" ");
                }
                builder.append(a.get(last - 1));
            }
            else {
                final int spaces = b - (totalChars / gaps);
                final int rest = b - (totalChars % gaps);
                for (int i = index; i < (last - 1); i++) {
                    builder.append(a.get(i));
                    builder.append(" ");
                    for (int j = 0; j < (spaces + ((i - index) < rest ? 1 : 0)); j++) {
                        builder.append(" ");
                    }
                }
                builder.append(a.get(last - 1));
            }
            res.add(builder.toString());
            index = last;

        }
        return res;
    }
}
