package com.deepak.leetCode.heapQueueStack;

import java.util.PriorityQueue;
import java.util.Scanner;

public class QHeap1 {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0 ; i < size; i++){

            int action = in.nextInt();

            if(action == 1){
                queue.add(in.nextInt());
            }else if(action == 2){
                int toDelete = in.nextInt();
                if(!queue.isEmpty()){
                    queue.remove(toDelete);
                }
            }else if (action == 3) {
                System.out.println(queue.peek());
            }
        }

    }

}
