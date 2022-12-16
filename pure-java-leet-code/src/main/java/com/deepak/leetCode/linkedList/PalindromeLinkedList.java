package com.deepak.leetCode.linkedList;

public class PalindromeLinkedList {

    public static void main(String[] args) {
         ListNode llHeadPalindrome = LinkedListUtils.getLLHeadPalindrome();
        LinkedListUtils.printLL(llHeadPalindrome);

        System.out.println(isPalindrome(llHeadPalindrome));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow= reverse(slow);
        while(slow != null && (slow.val == head.val)){
            head = head.next;
            slow = slow.next;
        }
        return slow == null;
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
