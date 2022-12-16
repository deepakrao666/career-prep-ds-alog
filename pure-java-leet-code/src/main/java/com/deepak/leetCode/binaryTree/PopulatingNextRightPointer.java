package com.deepak.leetCode.binaryTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointer {

    public Node connect(Node root) {
        if(root == null)
            return null;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (poll != null) {
                    if (prev != null) {
                        prev.next = poll;
                    }
                    prev = poll;
                    if (queue.size() == 1) {
                        poll.next = null;
                    }
                    if (poll.left != null)
                        queue.add(poll.left);
                    if (poll.right != null)
                        queue.add(poll.right);
                }
            }
        }
        return root;
    }


    public Node connectFirstTry(Node root) {

        List<List<Node>> listOfNodes = new LinkedList<>();

        bfs(root, listOfNodes, 0);

        listOfNodes.forEach(e -> {
            e.forEach(f -> System.out.print(f.val + " "));
            System.out.println();
        });
        return root;
    }

    private Node bfs(Node root, List<List<Node>> listOfNodes, int level) {
        if (root == null)
            return null;

        if (listOfNodes.size() <= level) {
            listOfNodes.add(new LinkedList<>());
        }

        List<Node> nodes = listOfNodes.get(level);
        nodes.add(root);

        //System.out.println(root.val + " " + level);

        bfs(root.left, listOfNodes, level + 1);
        bfs(root.right, listOfNodes, level + 1);


        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        nodes.get(nodes.size() - 1).next = null;

        return root;
    }


}
