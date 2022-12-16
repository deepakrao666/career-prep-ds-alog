package com.deepak.leetCode.treesAndGraphs;

import java.util.*;

public class PossibleBipartition {

    public boolean possibleBipartition(int n, int[][] dislikes) {

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        List<List<Integer>> adjList = new LinkedList<>();
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] row : dislikes) {
            int from = row[0];
            int to = row[1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        System.out.println(adjList);
        for (int i = 1; i < n + 1; i++) {
            if (color[i] == -1) {
                Stack<Integer> stack = new Stack<>();
                color[i] = 0;
                stack.push(i);
                while (!stack.isEmpty()) {
                    Integer node = stack.pop();
                    for (Integer child : adjList.get(node)) {
                        if (color[child] == -1) {
                            stack.push(child);
                            color[child] = color[node] ^ 1;
                        } else if (color[child] == color[node]) {
                            System.out.println(Arrays.toString(color));
                            return false;
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(color));

        return true;
    }
}
