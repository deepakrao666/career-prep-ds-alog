package com.deepak.leetCode.heapQueueStack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {

        Stack<Integer> toRemove = new Stack<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(')
                stack.push(i);
            else if (s.charAt(i) == ')') {

                if (stack.isEmpty())
                    toRemove.push(i);
                else {
                    if (s.charAt(stack.peek()) == '(') {
                        stack.pop();
                    } else {
                        toRemove.push(i);
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            toRemove.push(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            if (toRemove.contains(i)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }


//    public String minRemoveToMakeValid(String s) {
//
//        Stack<Integer> stack = new Stack<>();
//        Set<Integer> toRemove = new HashSet<>();
//
//        StringBuilder sb = new StringBuilder();
//
//        for(int i =0 ; i < s.length(); i++){
//
//            if(s.charAt(i) == '('){
//                stack.push(i);
//            }else if(s.charAt(i) == ')'){
//
//                if(stack.isEmpty()){
//                   toRemove.add(i);
//                }else {
//                    stack.pop();
//                }
//            }
//        }
//
//        while (!stack.isEmpty()){
//            toRemove.add(stack.pop());
//        }
//
//        for(int i =0 ; i < s.length(); i++){
//            if(!toRemove.contains(i)){
//                sb.append(s.charAt(i));
//            }
//        }
//
//
//        return sb.toString();
//    }

}
