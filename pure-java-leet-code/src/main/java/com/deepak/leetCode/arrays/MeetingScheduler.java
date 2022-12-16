package com.deepak.leetCode.arrays;

import java.util.*;

public class MeetingScheduler {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> timeslots = new PriorityQueue<>(Comparator.comparingInt(slot -> slot[0]));

        for (int[] slot: slots1) {
            if (slot[1] - slot[0] >= duration) timeslots.offer(slot);
        }
        for (int[] slot: slots2) {
            if (slot[1] - slot[0] >= duration) timeslots.offer(slot);
        }

        while (timeslots.size() > 1) {
            int[] slot1 = timeslots.poll();
            int[] slot2 = timeslots.peek();
            if (slot2 != null && slot1[1] >= slot2[0] + duration) {
                return new ArrayList<>(Arrays.asList(slot2[0], slot2[0] + duration));
            }
        }
        return new ArrayList<>();
    }
}
