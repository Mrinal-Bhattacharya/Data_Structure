package com.interviewbit.string.math;

import java.util.HashMap;

public class IntegerToRoman {
    private static int[] bases = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static HashMap<Integer, String> map = new HashMap<>();

    private static void setup() {
        IntegerToRoman.map.put(1, "I");
        IntegerToRoman.map.put(4, "IV");
        IntegerToRoman.map.put(5, "V");
        IntegerToRoman.map.put(9, "IX");
        IntegerToRoman.map.put(10, "X");
        IntegerToRoman.map.put(40, "XL");
        IntegerToRoman.map.put(50, "L");
        IntegerToRoman.map.put(90, "XC");
        IntegerToRoman.map.put(100, "C");
        IntegerToRoman.map.put(400, "CD");
        IntegerToRoman.map.put(500, "D");
        IntegerToRoman.map.put(900, "CM");
        IntegerToRoman.map.put(1000, "M");
    }

    public String intToRoman(final int A) {
        final String[] m = {"", "M", "MM", "MMM"};
        final String[] c = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        final String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        final String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        // Converting to roman
        final String thousands = m[A / 1000];
        final String hundereds = c[(A % 1000) / 100];
        final String tens = x[(A % 100) / 10];
        final String ones = i[A % 10];

        final String ans = thousands + hundereds + tens + ones;

        return ans;
    }

    public String intToRoman2(int a) {
        IntegerToRoman.setup();
        String result = "";
        for (final int i : IntegerToRoman.bases) {
            while (a >= i) {
                result += IntegerToRoman.map.get(i);
                a -= i;
            }
        }
        return result;
    }
}
