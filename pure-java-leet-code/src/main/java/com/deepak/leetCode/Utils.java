package com.deepak.leetCode;

public class Utils {
    public static void main(String[] args) {
        printArrayString();
    }

    public static void printArr(int[] arr){
        System.out.print("[");
        for(int i: arr){
            System.out.print( i + " ");
        }
        System.out.println("]");

    }

    private static void printArrayString(){
        String arr = "[[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]";

        arr = arr.replace("[", "{");
        arr = arr.replace("]", "}");
        arr = arr.replace("\"", "'");

        System.out.println(arr);
    }

}
