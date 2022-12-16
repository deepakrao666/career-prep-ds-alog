package com.deepak.leetCode.strings;

import java.util.Arrays;
import java.util.List;

public class DesignPdfViewer {
    public static void main(String[] args) {
        final List<Integer> strings = Arrays.asList(1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5);
        final int abc = designerPdfViewer(strings, "abc");
    }
    public static int designerPdfViewer(List<Integer> h, String word) {

        int max = -1;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            int index = word.charAt(i) - 'a';
            //System.out.println(index);
            max = Math.max(max, h.get(index));
        }

        return max * length;
    }
}
