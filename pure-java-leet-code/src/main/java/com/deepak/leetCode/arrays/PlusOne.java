package com.deepak.leetCode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PlusOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 9, 9})));
    }

    public static int[] plusOne(int[] digits) {

        int n = digits.length;
        Stack<Integer> stack = new Stack<>();

        int carry = 1;

        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            stack.push(sum % 10);
        }

        if(carry != 0)
            stack.push(carry);

        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        return res;
    }


//    public static int[] plusOne(int[] digits) {
//        int addition = 0;
//        int i = digits.length - 1;
//
//        if(digits[digits.length-1] == 9){
//            digits[digits.length -1 ] = 0;
//            addition = 1;
//        }
//
//        i--;
//
//        while (i != -1){
//
//          if(addition == 1){
//              digits[i]++;
//              addition = 0;
//          }
//
//           if(digits[i] == 10){
//               digits[i] = 0;
//               addition = 1;
//           }
//
//        }
//
//
//        System.out.println(addition + " " + Arrays.toString(digits));
//
//        if (addition == 0) {
//            return digits;
//        } else {
//            int[] res = new int[digits.length + 1];
//            res[0] = 1;
//            System.arraycopy(digits, 0, res, 1, digits.length + 1 - 1);
//            return res;
//        }
//    }
}
