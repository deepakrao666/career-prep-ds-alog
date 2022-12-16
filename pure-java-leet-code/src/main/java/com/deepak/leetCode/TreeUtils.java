package com.deepak.leetCode;

public class TreeUtils {

    public static TreeNode getTreeRoot(){
        TreeNode left3 = new TreeNode(4);
        TreeNode right3 = new TreeNode(5);
        TreeNode left4 = new TreeNode(6);
        TreeNode right4 = new TreeNode(7);

        TreeNode left2 = new TreeNode(2);
        left2.left = left3;
        left2.right = right3;

        TreeNode right2 = new TreeNode(3);
        right2.left = left4;
        right2.right = right4;

        TreeNode root = new TreeNode(1);

        root.left = left2;
        root.right = right2;

        return root;
    }
}
