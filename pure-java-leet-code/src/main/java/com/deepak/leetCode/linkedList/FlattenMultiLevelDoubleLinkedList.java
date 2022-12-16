package com.deepak.leetCode.linkedList;


public class FlattenMultiLevelDoubleLinkedList {


    public Node flatten(Node head) {
        if (head == null)
            return null;

        Node next = head.next;
        Node child = head.child;

        if (child != null) {
            head.next = child;
            child.prev = head;

            Node tempChild = child;
            Node childPrevNode = head;

            while (tempChild != null) {

                childPrevNode = tempChild;
                if(tempChild.child != null){
                    System.out.println("calling flatten on child");
                    flatten(tempChild);
                }
                tempChild = tempChild.next;
            }

            if(next != null){
                childPrevNode.next = next;
                next.prev = childPrevNode;
            }
            head.child = null;
        }
        flatten(next);

        return head;
    }

    //    private void printLL(Node node) {
//        System.out.println("val " + node.val);
//        Node head = node;
//        while (head != null) {
//            System.out.printf("[val = %d, prev = %s, next = %s, child = %s],\n", head.val,
//                    head.prev != null ? head.prev.val : "null",
//                    head.next != null ? head.next.val : "null",
//                    head.child != null ? head.child.val : "null"
//            );
//            head = head.next;
//        }
//        head = node;
//        System.out.print("[");
//        while (head != null) {
//            System.out.print(head.val + " ");
//            head = head.next;
//        }
//        System.out.println("]");
//        System.out.println();
//    }

}
