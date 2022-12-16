package com.deepak.leetCode.linkedList;


import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        if (list1 != null) queue.add(list1);
        if (list2 != null) queue.add(list2);
        ListNode res = new ListNode();
        ListNode temp = res;

        while (!queue.isEmpty()) {

            ListNode poll = queue.poll();

            if (poll.next != null) {
                queue.add(poll.next);
            }
            temp.next = new ListNode(poll.val);
            temp = temp.next;


        }

        return res.next;
    }

}
