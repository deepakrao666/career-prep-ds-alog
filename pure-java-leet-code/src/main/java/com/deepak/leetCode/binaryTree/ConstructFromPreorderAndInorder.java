package com.deepak.leetCode.binaryTree;



import java.util.HashMap;
import java.util.Map;

public class ConstructFromPreorderAndInorder {

    // map of value and position
    private static Map<Integer, Integer> inorderMap = new HashMap<>();
    private static int preOrderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        preOrderIndex = 0;
        return arrayToTree(preorder, 0, preorder.length - 1);

    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right)
            return null;

        int headValue = preorder[preOrderIndex++];
        TreeNode head = new TreeNode(headValue);
        ;

        head.left = arrayToTree(preorder, left, inorderMap.get(headValue) - 1);
        head.left = arrayToTree(preorder, inorderMap.get(headValue) + 1, right);

        return head;
    }
}
