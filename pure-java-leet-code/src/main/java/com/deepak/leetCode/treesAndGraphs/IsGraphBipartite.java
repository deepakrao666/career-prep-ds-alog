package com.deepak.leetCode.treesAndGraphs;

import java.util.Arrays;
import java.util.Stack;

public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        if (graph.length == 1)
            return true;

        int[] color = new int[graph.length];
        Arrays.fill(color, -1);


        for (int i = 0; i < graph.length; i++) {

            if (color[i] == -1) {
                color[i] = 0;

                Stack<Integer> stack = new Stack<>();
                stack.push(i);

                while (!stack.isEmpty()) {
                    Integer node = stack.pop();
                    int[] children = graph[node];
                    for (int child : children) {

                        if (color[child] == -1) {
                            stack.push(child);
                            color[child] = color[node] ^ 1;
                        } else if (color[node] == color[child]) {
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

