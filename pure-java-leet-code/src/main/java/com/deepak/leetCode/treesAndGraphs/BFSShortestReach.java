package com.deepak.leetCode.treesAndGraphs;

import java.util.*;

public class BFSShortestReach {

    public static void main(String[] args) {
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(1, 3)
        );

        List<Integer> bfs = bfs(4, 3, edges, 1);
        System.out.println(bfs);
        System.out.println("--");
        List<List<Integer>> edges2 = Arrays.asList(
                Arrays.asList(2, 3)
        );

        final List<Integer> bfs2 = bfs(3, 1, edges2, 2);
        System.out.println(bfs2);


        System.out.println("--");
        List<List<Integer>> edge3 = Arrays.asList(
                Arrays.asList(1,2),
                Arrays.asList(1,3),
                Arrays.asList(3,4)
        );

        final List<Integer> bfs3 = bfs(5, 3, edge3, 1);
        System.out.println(bfs3);

    }

    public static List<Integer> bfs(int noOfNodes, int noOfEdges, List<List<Integer>> edges, int start) {
        List<Integer> res = new LinkedList<>();
        int[] distance = new int[noOfNodes];
        Arrays.fill(distance, -1);
        List<List<Integer>> adjList = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);


        for (int i = 0; i <= noOfNodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            adjList.get(edge.get(0)).add(edge.get(1));
        }

        int weight = 0;

        while (!queue.isEmpty()) {
            Integer head = queue.poll();
            List<Integer> leaves = adjList.get(head);
            if(leaves.size() != 0){
                weight += 6;
            }

            for (Integer leaf : leaves) {
                //System.out.println(leaf);
                if (distance[leaf - 1] == -1) {
                    queue.add(leaf);
                    distance[leaf - 1] = weight;
                }
            }



        }

        for (int i = 0; i < noOfNodes; i++) {
            if (i != start - 1)
                res.add(distance[i]);
        }


        return res;
    }


}
