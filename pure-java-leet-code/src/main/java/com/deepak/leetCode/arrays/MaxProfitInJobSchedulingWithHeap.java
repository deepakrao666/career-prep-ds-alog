package com.deepak.leetCode.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxProfitInJobSchedulingWithHeap {
    // TODO : doordash

    public int jobScheduling(int[] startTime, int[] endTime, int[] profits) {
        int maxProfit = 0;

        List<List<Integer>> jobs = new ArrayList<>();

        for(int i = 0; i < startTime.length; i++){

            List<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profits[i]);

            jobs.add(currJob);
        }

        jobs.sort(Comparator.comparingInt(a -> a.get(0)));

        System.out.println(jobs);

        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));

        for(List<Integer> job : jobs ){
            int start = job.get(0);
            int end = job.get(1);
            int profit = job.get(2);

            while (!queue.isEmpty() && start>= queue.peek().get(0)){
                maxProfit = Math.max(maxProfit,  queue.poll().get(1));
            }

            List<Integer> combinedJob = new ArrayList<>();
            combinedJob.add(end);
            combinedJob.add(profit + maxProfit);

            queue.add(combinedJob);
        }

        while (!queue.isEmpty()){
            maxProfit = Math.max(maxProfit, queue.poll().get(1));
        }

        return maxProfit;
    }

}
