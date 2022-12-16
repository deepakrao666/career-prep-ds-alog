package com.deepak.leetCode.design;

import java.util.Arrays;

public class MoveAverageFromDataStream {
    int size;
    int currCount;
    int currSize;
    int[] arr;

    public MoveAverageFromDataStream(int size) {
        this.size = size;
        this.currSize = 0;

        this.arr = new int[size];
        Arrays.fill(this.arr, 0);
    }

    public double next(int val) {


        System.out.println(currCount);
        arr[currCount] = val;
        currCount = (currCount + 1) % size;


        if (currSize < size)
            currSize++;

        int sum = 0;
        for (int i = 0; i < currSize; i++) {
            sum += arr[i];
        }


        return (double) sum/currSize;
    }
}
