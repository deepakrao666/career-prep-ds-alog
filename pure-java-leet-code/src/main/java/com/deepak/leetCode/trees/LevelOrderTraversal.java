package com.deepak.leetCode.trees;

import com.deepak.leetCode.TreeNode;
import com.deepak.leetCode.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {

        System.out.println(levelOrder(TreeUtils.getTreeRoot()));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<List<Integer>> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                final TreeNode poll = queue.poll();
                if (poll != null) {
                    level.add(poll.val);

                    if (poll.left != null)
                        queue.add(poll.left);
                    if (poll.right != null)
                        queue.add(poll.right);

                }
            }
            res.add(level);
        }

        return res;
    }
}
