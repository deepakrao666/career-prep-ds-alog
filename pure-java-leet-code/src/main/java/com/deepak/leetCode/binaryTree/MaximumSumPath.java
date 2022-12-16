package com.deepak.leetCode.binaryTree;

public class MaximumSumPath {

    // TODO : doordash

    public int maxPathSum(TreeNode root) {

        int[] maxValue = new int[1]; // because array can be referenced
        maxValue[0] = Integer.MIN_VALUE;

        maxPathDown(root,maxValue);
        return maxValue[0];

    }

    private int maxPathDown(TreeNode node, int[] maxValue)
    {
        if(node==null)
            return 0 ;

        int left = Math.max(0,maxPathDown(node.left,maxValue));
        int right = Math.max(0,maxPathDown(node.right,maxValue));

        maxValue[0] = Math.max(maxValue[0],left+right+node.val);

        return Math.max(left,right) + node.val ;
    }
}
