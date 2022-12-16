package com.deepak.leetCode.linkedList;


public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null) return false;

        ListNode turtle = head;

        ListNode rabbit = head.next;


        while (turtle != rabbit) {

            if (rabbit == null || rabbit.next == null)
                return false;

            turtle = turtle.next;
            rabbit = rabbit.next.next;
        }

        return true;
    }

}
