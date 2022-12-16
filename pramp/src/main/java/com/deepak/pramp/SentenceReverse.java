package com.deepak.pramp;

public class SentenceReverse {


    public static char[] reverseWords(char[] arr) {
        // your code goes here
        mirrorReverse(arr, 0, arr.length - 1);

        Integer wordStart = null;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == ' ') {
                if (wordStart != null) {
                    mirrorReverse(arr, wordStart, i - 1);
                    wordStart = null;
                }
            } else if (i == arr.length - 1) {
                if (wordStart != null) {
                    mirrorReverse(arr, wordStart, i);
                }
            } else {
                if (wordStart == null) {
                    wordStart = i;
                }
            }
        }

        return arr;
    }

    private static void mirrorReverse(char[] arr, int start, int end) {
        char temp;

        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


//   public static char[] reverseWords(char[] arr) {
//        // your code goes here
//        char[] res = new char[arr.length];
//        Arrays.fill(res, ' ');
//
//        int pointer = 0;
//        int wordLength = 0;
//
//        for (int i = 0; i < arr.length; i++) {
//            wordLength++;
//            if (arr[i] == ' ') {
//                addWordToArray(pointer, wordLength, arr, res);
//                for (int j = i + 1; j < arr.length; j++) {
//                    if (arr[j] != ' ') {
//                        pointer = j;
//                        i = j;
//                        break;
//                    }
//                }
//                wordLength = 0;
//            }
//        }
//        return res;
//    }
//
//    private static void addWordToArray(int start, int wordLength, char[] source, char[] target) {
//
//        for (int i = 0; i < wordLength; i++) {
//            target[target.length - start - wordLength + i] = source[start + i];
//        }
//
//    }
}
