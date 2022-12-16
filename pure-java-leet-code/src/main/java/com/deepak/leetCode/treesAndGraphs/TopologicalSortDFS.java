package com.deepak.leetCode.treesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSortDFS {

    private static int[] topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {

        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[V + 1];

        Arrays.fill(visited, 0);

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, stack, adj);
            }
        }


        int[] resTopologicallySorted = new int[V];
        int i = 0;

        while (!stack.isEmpty()) {
            resTopologicallySorted[i++] = stack.pop();
        }

        return resTopologicallySorted;
    }

    public static void dfs(int node, int[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = 1;
        for (Integer i : adj.get(node)) {
            if (visited[i] == 0) {
                dfs(i, visited, stack, adj);
            }
        }
        stack.push(node);
    }
}
