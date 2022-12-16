package com.deepak.leetCode.linkedList;

public class DetectLinkedListCycle {

    private static boolean hasCycle(SinglyLinkedListNode head) {

        if (head == null || head.next == null)
            return false;

        SinglyLinkedListNode turtle = head;
        SinglyLinkedListNode rabbit = head.next;

        while (true) {

            if (rabbit.next == null || rabbit.next.next == null) {
                return false;
            }
            if (turtle == rabbit) {
                return true;
            }

            turtle = turtle.next;
            rabbit = rabbit.next.next;
        }
    }


    private static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }
}
