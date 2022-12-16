package com.deepak.leetCode.binaryTree;


public class FlattenBinaryTree {

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        convertToPreOrder(root);

    }

    private TreeNode convertToPreOrder(TreeNode root) {
        if (root == null)
            return null;

        if (root.left == null && root.right == null)
            return root;

        TreeNode leftTail = convertToPreOrder(root.left);
        TreeNode rightTail = convertToPreOrder(root.right);

        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        return rightTail == null ? leftTail : rightTail;
    }


}
