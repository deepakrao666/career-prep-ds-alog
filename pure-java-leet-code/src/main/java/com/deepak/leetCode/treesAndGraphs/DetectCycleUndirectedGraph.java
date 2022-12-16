package com.deepak.leetCode.treesAndGraphs;

import java.util.*;

public class DetectCycleUndirectedGraph {

    private static class Node {
        int first;
        int second;

        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);
        for (int i = 0; i < V; i++)
            if (!vis[i])
                if (checkForCycle(adj, i, vis))
                    return true;

        return false;
    }

    // BFS
    static boolean checkForCycle(List<List<Integer>> adj, int s, boolean[] vis) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, -1));
        vis[s] = true;

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();

            for (Integer it : adj.get(node)) {
                if (!vis[it]) {
                    q.add(new Node(it, node));
                    vis[it] = true;
                } else if (par != it) return true;
            }
        }

        return false;
    }

}
