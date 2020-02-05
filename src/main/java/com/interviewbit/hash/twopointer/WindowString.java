package com.interviewbit.hash.twopointer;

import java.util.HashMap;

public class WindowString {
    public String minWindow(String s, String t) {
        String result = "";
        HashMap<Character, Integer> target = new HashMap<>();
        for(int i = 0;  i < t.length(); i++) {
            if(target.containsKey(t.charAt(i))){
                target.put(t.charAt(i), target.get(t.charAt(i)) + 1);
            }
            else {
                target.put(t.charAt(i), 1);
            }
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int minLen = s.length() + 1;

        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(target.containsKey(c)) {
                if(map.containsKey(c)) {
                    if(map.get(c) < target.get(c)) {
                        count++;
                    }
                    map.put(c, map.get(c) + 1);
                }
                else {
                    map.put(c, 1);
                    count++;
                }
            }

            if(count == t.length()) {
                char sc = s.charAt(left);
                while(!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
                    if(map.containsKey(sc) && map.get(sc) > target.get(sc)) {
                        map.put(sc, map.get(sc) - 1);
                    }
                    left++;
                    sc = s.charAt(left);
                }
                if(i - left + 1 < minLen) {
                    result = s.substring(left, i+1);
                    minLen = i - left + 1;
                }
            }
        }
        return result;
    }
}
