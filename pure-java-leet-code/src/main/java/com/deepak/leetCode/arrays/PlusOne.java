package com.deepak.leetCode.arrays;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        plusOne(new int[]{1, 9, 9});
    }

    public static int[] plusOne(int[] digits) {
        int addition = 0;
        int i = digits.length - 1;

        if(digits[digits.length-1] == 9){
            digits[digits.length -1 ] = 0;
            addition = 1;
        }

        i--;

        while (i != -1){

          if(addition == 1){
              digits[i]++;
              addition = 0;
          }

           if(digits[i] == 10){
               digits[i] = 0;
               addition = 1;
           }

        }


        System.out.println(addition + " " + Arrays.toString(digits));

        if (addition == 0) {
            return digits;
        } else {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length + 1 - 1);
            return res;
        }
    }
}
