package com.deepak.leetCode.trees;

import com.deepak.leetCode.TreeNode;
import com.deepak.leetCode.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    public static void main(String[] args) {
        System.out.println(preorderTraversal(TreeUtils.getTreeRoot()));
    }

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            res.add(root.val);
            if(root.right != null){
                st.push(root.right);
            }
            if(root.left != null){
                st.push(root.left);
            }
        }
        return res;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }
    public static void preorder(TreeNode root, List<Integer> res){
        if(root == null) return;

        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
