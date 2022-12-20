package com.deepak.leetCode.slidingWindow;

public class MaximizeConfusionOfExam {

    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("FFTFTTTFFF", 1));
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int j = 0, i = 0, count = 0, result = 0;
        int n = answerKey.length();

        while (j < n) {
            count += answerKey.charAt(j) == 'T' ? 1 : 0;
            int min = Math.min(count, j - i + 1 - count);

            System.out.println("count = " + count + ",  min = " + min);

            while (min > k) {
                count -= answerKey.charAt(i) == 'T' ? 1 : 0;
                i++;

                min = Math.min(count, j - i + 1 - count);
            }

            // ans
            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }
}
