package com.deepak.leetCode.dp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DicePermutations {

    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
//        diceRolls(2);

        final List<int[]> list = dicePerm(2);

        list.forEach(e -> System.out.println(Arrays.toString(e)));
    }

    private static void diceRolls(int noOfDice) {
        List<Integer> combination = new ArrayList<>();
        rollDice(noOfDice, combination);
    }

    // recursive rollDice method
    private static void rollDice(int n, List<Integer> combination) {
        if (n == 0) {
            System.out.println(combination);
            res.add(combination);
        } else {
            for (int i = 1; i <= 6; i++) {
                combination.add(i);
                rollDice(n - 1, combination);
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static List<int[]> dicePerm(int n) {
        List<int[]> perms = new ArrayList<>();
        // Number of rows
        int rows = (int) Math.pow(6, n);
        int roll = 0;
        // Go column vise
        for (int i = 0; i < n; i++) {
            int val = 1;
            // Every roll number of times increment the dice
            roll = (int) Math.pow(6, n - i - 1);
            for (int j = 0; j < rows; j++) {
                if (i == 0)
                    perms.add(new int[n]);

                perms.get(j)[i] = val;
                if ((j + 1) % roll == 0) {
                    val++;
                }
                // Reset the dice to 1
                if (val > 6) {
                    val = 1;
                }
            }
        }
        return perms;
    }

}
