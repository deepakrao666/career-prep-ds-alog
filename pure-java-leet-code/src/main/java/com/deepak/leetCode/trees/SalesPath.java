package com.deepak.leetCode.trees;

public class SalesPath {

    static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }

    static class SalesPath2 {

        public static int getCheapestCost(Node rootNode) {

            System.out.println("start");

            // your code goes here
            int min = Integer.MAX_VALUE, pathCost = 0;

            return recursive(rootNode, min, 0);
        }

        // node.cost , currTotalCost, globalMinCost

        public static int recursive(Node node, int globalMinCost, int currTotalCost) {
            currTotalCost = globalMinCost + node.cost;

            if (currTotalCost > globalMinCost)
                return globalMinCost;

            // i am last leaf and curr<min
            if (node.children == null || node.children.length == 0)
                return currTotalCost;

            for (Node child : node.children) {
                currTotalCost = Math.min(currTotalCost, recursive(child, globalMinCost, currTotalCost));
            }

            return currTotalCost;
        }
    }

    /*********************************************
     * Driver program to test above method     *
     *********************************************/

    public static void main(String[] args) {

        System.out.println("start - 0 ");
        Node rootChild1 = new Node(5);
        rootChild1.children = new Node[]{new Node(4)};


        Node rootChild221 = new Node(10);
        Node rootChild22 = new Node(0);
        rootChild22.children = new Node[]{rootChild221};

        Node rootChild2111 = new Node(1);
        Node rootChild211 = new Node(1);
        rootChild211.children = new Node[]{rootChild2111};

        Node rootChild21 = new Node(2);
        rootChild21.children = new Node[]{rootChild211};


        Node rootChild2 = new Node(3);
        rootChild2.children = new Node[]{rootChild21, rootChild22};


        Node rootChild3 = new Node(6);
        rootChild3.children = new Node[]{new Node(1), new Node(5)};

        Node root = new Node(0);

        root.children = new Node[]{rootChild1, rootChild2, rootChild3};


        System.out.println("start - function");

        System.out.println(SalesPath2.getCheapestCost(root));

        System.out.println("end");
    }
}
