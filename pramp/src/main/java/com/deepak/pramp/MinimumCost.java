package com.deepak.pramp;

public class MinimumCost {

    private static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }
    /*********************************************
     * Driver program to test above method     *
     *********************************************/

    public static void main(String[] args) {
        SalesPath s1 = new SalesPath();

        Node one = new Node(0);
        Node two = new Node(5);
        Node three = new Node(3);
        Node four = new Node(6);
        Node five = new Node(1);

        one.children = new Node[]{two, three, four};
        three.children = new Node[]{five};

        System.out.println(SalesPath.getCheapestCost(one));

        System.out.println("Hello");
    }



    private static class SalesPath {

        private static int MIN = Integer.MAX_VALUE;

        public static int getCheapestCost(Node rootNode) {
            // your code goes here
            dfs(rootNode, 0);
            return MIN;
        }

        public static void dfs(Node node, int sum) {

            if (node.children == null || node.children.length == 0) {
                MIN = Math.min(MIN, sum + node.cost);
            } else {
                for (Node child : node.children) {
                    dfs(child, sum + node.cost);
                }
            }
        }
    }


}
