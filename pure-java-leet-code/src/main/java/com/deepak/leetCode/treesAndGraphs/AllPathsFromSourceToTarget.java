package com.deepak.leetCode.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class  AllPathsFromSourceToTarget {
    int lastElementOfGraph;
    List<List<Integer>> res = new ArrayList<>();
    int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        this.graph = graph;
        this.lastElementOfGraph = graph.length-1;

        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);
        this.backTrack(0, path);

        return this.res;
    }

    private void backTrack(int currNode, LinkedList<Integer> path) {
        System.out.println(currNode + ", target = "+ lastElementOfGraph);

        if(currNode == this.lastElementOfGraph){
            this.res.add(new ArrayList<>(path));
            return;
        }

        for(int next : this.graph[currNode]){
            path.addLast(next);
            this.backTrack(next, path);
            System.out.println("path = " + path);
            path.removeLast();
        }

        System.out.println(this.res);
    }

}
