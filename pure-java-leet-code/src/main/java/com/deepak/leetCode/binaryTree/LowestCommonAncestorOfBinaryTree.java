package com.deepak.leetCode.binaryTree;


import java.util.*;

public class LowestCommonAncestorOfBinaryTree {

    public TreeNode lowestCommonAncestorBestSubmitted(TreeNode root, TreeNode p, TreeNode q) {
        //my understanding of what lowestCommonAncestor() does:
        // if both p and q exist in Tree rooted at root, then return their LCA
        // if neither p and q exist in Tree rooted at root, then return null
        // if only one of p or q (NOT both of them), exists in Tree rooted at root, return the root

        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;                                // The tree rooted at root doesn't contain p nor q.
        } else if (left != null && right != null) {
            return root;                                // The current tree contains one node in the left and the other node in the right subtree so it is the LCA (the final result).
        } else if (left == null) {
            return right;                               // Left doesn't contain p nor q but right contains one of them or both.
        } else {
            return left;                                // Right doesn't contain p nor q but left contains one of them or both.
        }
    }

// // recursion
// class Solution {
//     private TreeNode ans;

//     private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
//         if (currentNode == null) {
//             return false;
//         }

//         int left = this.recurseTree(currentNode.left, p, q)? 1 : 0;

//         int right = this.recurseTree(currentNode.right, p, q)? 1 : 0;

//         int mid = (currentNode == p || currentNode == q)? 1 : 0;
//         // If at any point in the traversal, any two of the three flags left, right or mid become True, this means we have found the lowest common ancestor for the nodes p and q.
//         if (mid + left + right >= 2) {
//             this.ans = currentNode;
//         }

//         return (mid + left + right > 0);
//     }

    //     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         this.recurseTree(root, p, q);
//         return this.ans;
//     }
// }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Stack<TreeNode> stack = new Stack<>();

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            final TreeNode pop = stack.pop();

            if (pop.left != null) {
                stack.add(pop.left);
                parent.put(pop.left, pop);
            }
            if (pop.right != null) {
                stack.add(pop.right);
                parent.put(pop.right, pop);
            }
        }

        Set<TreeNode> ancestor = new HashSet<>();

        while (p != null) {
            ancestor.add(p);
            p = parent.get(p);
        }

        while (!ancestor.contains(q)) {
            q = parent.get(q);
        }


        return q;
    }

    public Node lowestCommonAncestorWithParent(Node p, Node q) {

        if (p.parent != null && q.parent != null && p.parent.val == q.parent.val)
            return p.parent;

        Map<Integer, Node> map = new HashMap<>();
        map.put(p.val, p);
        // go to parent
        Node tempLeft = p.parent;


        while (tempLeft != null) {
            map.put(tempLeft.val, tempLeft);
            tempLeft = tempLeft.parent;
        }

        while (q != null) {
            if (map.containsKey(q.val)) {
                return q;
            }
            q = q.parent;

        }
        return null;
    }
}
