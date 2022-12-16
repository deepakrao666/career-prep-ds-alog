package com.deepak.leetCode.strings;

import java.util.Stack;

public class MinimumAddTOMakeValidParentheses {

    public int minAddToMakeValid(String s) {
        int countClose = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(s.charAt(i));
            else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    countClose++;
                }
            }
        }
        return stack.isEmpty() ? countClose : stack.size() +  countClose;
    }


}
