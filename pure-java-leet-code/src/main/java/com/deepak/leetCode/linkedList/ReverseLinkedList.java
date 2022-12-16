package com.deepak.leetCode.linkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = LinkedListUtils.getLLHead();
        LinkedListUtils.printLL(head);
        head = reverse(head);
        LinkedListUtils.printLL(head);
    }

    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode res = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }


}
