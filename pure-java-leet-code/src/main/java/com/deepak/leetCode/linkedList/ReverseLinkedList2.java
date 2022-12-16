package com.deepak.leetCode.linkedList;


public class ReverseLinkedList2 {


    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == 1) {
            return reverseNNodes(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);

        return head;
    }

    ListNode next = null;
    private ListNode reverseNNodes(ListNode head, int n) {
        if (n == 1) {
            next = head.next;
            return head;
        }
        ListNode last = reverseNNodes(head.next, n - 1);
        head.next.next = head;
        head.next = next;
        return last;
    }


    private void printLL(ListNode node) {
        System.out.println("val " + node.val);
        ListNode head = node;
        while (head != null) {
            System.out.printf("[val = %d, next = %s],\n", head.val,
                    head.next != null ? head.next.val : "null"
            );
            head = head.next;
        }
        head = node;
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("]");
        System.out.println();
    }
}
