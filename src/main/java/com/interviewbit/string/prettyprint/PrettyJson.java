package com.interviewbit.string.prettyprint;

import java.util.ArrayList;
import java.util.Collections;

public class PrettyJson {
    public ArrayList<String> prettyJSON(final String A) {
        final ArrayList<String> ans = new ArrayList<>();

        int openBrace = 0;
        int closedBrace = 0;
        final StringBuilder sb = new StringBuilder();
        final char[] chars = A.toCharArray();

        for (final char c : chars) {
            if ("{[".indexOf(c) != -1) {
                if (sb.length() != 0) {
                    ans.add(String.join("", Collections.nCopies(openBrace - closedBrace, "\t")) + sb.toString());
                    sb.setLength(0);
                }
                openBrace++;
                sb.append(c);
                ans.add(String.join("", Collections.nCopies(openBrace - closedBrace - 1, "\t")) + sb.toString());
                sb.setLength(0);
            }
            else if ("}]".indexOf(c) != -1) {
                if (sb.length() != 0) {
                    ans.add(String.join("", Collections.nCopies(openBrace - closedBrace, "\t")) + sb.toString());
                    sb.setLength(0);
                }
                closedBrace++;
                sb.append(c);
            }
            else if (c == ',') {
                sb.append(',');
                ans.add(String.join("", Collections.nCopies(openBrace - closedBrace, "\t")) + sb.toString());
                sb.setLength(0);
            }
            else {
                sb.append(c);
            }
        }
        if (sb.length() != 0) {
            ans.add(sb.toString());
        }

        return ans;
    }
}
