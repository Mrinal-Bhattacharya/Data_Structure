package com.interviewbit.stack.example;

import java.util.Stack;

public class ReverseString {
    public String reverseString(String A) {
        Stack<Character> stk = new Stack<Character>();
        for(int i=0;i<A.length();i++) {
            stk.push(A.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.toString();
    }
    public String reverseString2(String a) {
        char[] arr = a.toCharArray();
        for(int i=0; i < arr.length/2; i++){
            swap(arr, i, arr.length-1-i);
        }
        return new String(arr);
    }

    public void swap(char[] arr, int i, int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
