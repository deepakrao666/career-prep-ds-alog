package com.deepak.leetCode.linkedList;


public class AddTwoNumbers {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode res = new ListNode();
        ListNode temp = res;

        int carry = 0;

        while (l1 != null || l2 != null) {

            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;

            temp.next = new ListNode(sum);
            temp = temp.next;

            l1 = (l1 != null ? l1.next : null) != null ? l1.next : null ;
            l2 = (l2 != null ? l2.next : null) != null ? l2.next : null ;


        }

        if(carry != 0){
            temp.next = new ListNode(carry);
        }

        res = reverseList(res.next);

        return res;
    }

}
