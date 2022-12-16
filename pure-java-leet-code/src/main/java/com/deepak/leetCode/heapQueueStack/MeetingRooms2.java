package com.deepak.leetCode.heapQueueStack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public static void main(String[] args) {
        MeetingRooms2 meetingRooms2 = new MeetingRooms2();

        meetingRooms2.minMeetingRooms(new int[][]{{1, 3}, {2, 6}});
    }

    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        System.out.println(Arrays.deepToString(intervals));

        PriorityQueue<Integer> heap = new PriorityQueue<>(
                intervals.length,
                Comparator.comparingInt(o -> o)
        );

        for (int[] interval : intervals) {

            if (!heap.isEmpty()) {
                // if start time is greater than end time, then room is free
                // poll the heap, to empty room.
                if (interval[0] >= heap.peek()) {
                    heap.poll();
                }
            }
            heap.add(interval[1]);

        }


        return heap.size();
    }
}
