package com.deepak.leetCode.dp;

public class BeautifulNumbers {

    public static long solve(int l, int r) {
        long res = 0;
        for (int i = l; i <= r; i++) {
            int curr = i;

            while (curr != 1 && curr != 4) {

                int temp;
                int sum = 0;
                while (curr > 0) {
                    temp = curr % 10;
                    sum = sum + (temp * temp);
                    curr = curr / 10;
                }

                curr = sum;
            }

            if (curr == 1) {
                res += i;
            }
        }
        return res;
    }

}
