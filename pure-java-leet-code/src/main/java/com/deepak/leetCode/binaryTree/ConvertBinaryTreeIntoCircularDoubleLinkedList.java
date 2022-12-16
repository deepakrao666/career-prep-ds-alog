package com.deepak.leetCode.binaryTree;


import java.util.Stack;

public class ConvertBinaryTreeIntoCircularDoubleLinkedList {

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return root;

        Node first = null;
        Node last = null;
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (last != null) {
                last.right = curr;
                curr.left = last;
            } else {
                first = curr;
            }
            last = curr;
            curr = curr.right;
        }

        first.left = last;
        last.right = first;

        return first;
    }


}
