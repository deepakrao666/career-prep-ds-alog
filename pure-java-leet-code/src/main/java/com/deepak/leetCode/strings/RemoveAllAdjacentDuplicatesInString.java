package com.deepak.leetCode.strings;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbbaca"));
    }

    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }

        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
