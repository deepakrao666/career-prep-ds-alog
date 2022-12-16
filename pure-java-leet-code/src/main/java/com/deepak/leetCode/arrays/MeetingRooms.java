package com.deepak.leetCode.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {

        if (intervals.length == 0)
            return true;
        if (intervals.length == 1) {
            return true;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        System.out.println(Arrays.deepToString(intervals));

        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (prevEnd > currStart)
                return false;

            prevEnd = currEnd;
        }
        return true;
    }
}
