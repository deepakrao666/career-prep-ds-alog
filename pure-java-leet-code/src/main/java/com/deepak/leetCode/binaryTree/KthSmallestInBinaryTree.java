package com.deepak.leetCode.binaryTree;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestInBinaryTree {

    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;

        PriorityQueue<TreeNode> heap = new PriorityQueue<>(Comparator.comparing( o -> o.val));
        heap.add(root);

        populateHeap(root, heap);
        List<Integer> list = new LinkedList<>();
        while (!heap.isEmpty()){
            list.add(heap.poll().val);
        }
        System.out.println(list);


        return heap.peek().val;
    }

    private void populateHeap(TreeNode root, PriorityQueue<TreeNode> heap) {
        if (root == null)
            return;

        populateHeap(root.left, heap);
        populateHeap(root.right, heap);
    }

}
