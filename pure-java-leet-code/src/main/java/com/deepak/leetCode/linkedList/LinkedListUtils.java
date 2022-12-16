package com.deepak.leetCode.linkedList;

public class LinkedListUtils {

    public static ListNode getLLHead(){
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        head.next = two;
        two.next = three;
        three.next = four;

        return head;
    }


    public static ListNode getLLHeadPalindrome(){
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(1);

        head.next = two;
        two.next = three;
        three.next = four;

        return head;
    }

    public static void printLL(ListNode head){
        ListNode temp = head;

        while (temp != null){
            System.out.print(temp.val + ", ");
            temp = temp.next;
        }
        System.out.println();
    }
}
