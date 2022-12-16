package com.deepak.leetCode;

public class GraphNode {
    public int val;
    public Node[] children;

    public GraphNode(int val){
        this.val = val;
        this.children = null;
    }

    public GraphNode(int val, Node[] children){
        this.val = val;
        this.children = children;
    }
}
