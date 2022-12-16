package com.deepak.leetCode.binaryTree;

import javafx.util.Pair;

import java.util.*;

public class VerticalOrderTraversal {
    // TODO : doordash

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();

        // init
        int column = 0;
        queue.add(new Pair<>(root, column));

        while (!queue.isEmpty()) {

            Pair<TreeNode, Integer> poll = queue.poll();
            root = poll.getKey();
            column = poll.getValue();

            if (root != null) {
                if (!map.containsKey(column))
                    map.put(column, new ArrayList<>());

                map.get(column).add(root.val);
                queue.add(new Pair<>(root.left, column - 1));
                queue.add(new Pair<>(root.right, column + 1));
            }
        }

        System.out.println(map);

        List<Integer> listOfKeys = new ArrayList<>(map.keySet());
        Collections.sort(listOfKeys);


        for (Integer key : listOfKeys) {
            res.add(map.get(key));
        }

        System.out.println("res = " + res);

        return res;
    }
}
