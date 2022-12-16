package com.deepak.leetCode.linkedList;


public class InsertionSortWithLinkedList {

    public ListNode insertionSortList(ListNode head) {
        ListNode temp = new ListNode();
        ListNode itr = head;


        while (itr != null) {

            ListNode prev = temp;

            while (prev.next != null && prev.next.val <= itr.val) {
                prev = prev.next;
            }

            ListNode next = itr.next;
            itr.next = prev.next;
            prev.next = itr;
            
            itr = next;

        }
        return temp.next;
    }
}
