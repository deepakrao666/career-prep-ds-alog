package com.deepak.leetCode.strings;

import java.util.Stack;

public class BasicCalculator2 {

    public int calculate(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                currentNumber = (currentNumber * 10) + (curr - '0');
            }

            if (!Character.isDigit(curr) && !Character.isWhitespace(curr) || i == s.length() - 1) {

                if (operator == '+') {
                    stack.push(currentNumber);
                }
                if (operator == '-') {
                    stack.push(-currentNumber);
                }
                if (operator == '*') {
                    stack.push(stack.pop() * currentNumber);
                }
                if (operator == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operator = curr;
                currentNumber = 0;
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }


        return result;
    }
}
