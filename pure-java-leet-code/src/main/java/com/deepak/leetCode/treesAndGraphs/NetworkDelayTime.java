package com.deepak.leetCode.treesAndGraphs;

import javafx.util.Pair;

import java.util.*;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int noOfNodes, int startingNode) {


        // <key, list of <neighbours, weights>
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();


        for (int[] time : times) {

            int key = time[0];
            int neighbour = time[1];
            int weight = time[2];

            Pair<Integer, Integer> pair = new Pair<>(neighbour, weight);

            if (map.containsKey(key)) {
                map.get(key).add(pair);
            } else {
                List<Pair<Integer, Integer>> list = new LinkedList<>();
                list.add(pair);
                map.put(key, list);
            }
        }

        System.out.println(map);


        if (!map.containsKey(startingNode))
            return -1;


        int[] signalReceived = new int[noOfNodes + 1];
        Arrays.fill(signalReceived, Integer.MAX_VALUE);
        signalReceived[startingNode] = 0;

        Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));

        queue.add(new Pair<>(0, startingNode));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> poll = queue.poll();

            Integer sourceWeight = poll.getKey();
            Integer sourceNode = poll.getValue();

            System.out.println(sourceNode);

            // if computation is completed already, then skip
            if (sourceWeight > signalReceived[sourceNode])
                continue;

            // if no children exist then continue
            // this serves as a visited counter.
            if (!map.containsKey(sourceNode))
                continue;

            for (Pair<Integer, Integer> pair : map.get(sourceNode)) {

                Integer child = pair.getKey();
                Integer weight = pair.getValue();

                if (signalReceived[child] > sourceWeight + weight) {
                    signalReceived[child] = sourceWeight + weight;
                    queue.add(new Pair<>(signalReceived[child], child));
                }

            }

            System.out.println(queue);
            System.out.println(Arrays.toString(signalReceived));
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= noOfNodes; i++) {
            answer = Math.max(answer, signalReceived[i]);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }


    // Adjacency list
    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();

    private void dijkstra(int[] signalReceivedAt, int sourceNode) {
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        pq.add(new Pair<>(0, sourceNode));

        // Time for starting node is 0
        signalReceivedAt[sourceNode] = 0;

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> topPair = pq.remove();

            int currNode = topPair.getValue();
            int currNodeTime = topPair.getKey();

            if (currNodeTime > signalReceivedAt[currNode]) {
                continue;
            }

            if (!adj.containsKey(currNode)) {
                continue;
            }

            // Broadcast the signal to adjacent nodes
            for (Pair<Integer, Integer> edge : adj.get(currNode)) {
                int time = edge.getKey();
                int neighborNode = edge.getValue();

                // Fastest signal time for neighborNode so far
                // signalReceivedAt[currNode] + time :
                // time when signal reaches neighborNode
                if (signalReceivedAt[neighborNode] > currNodeTime + time) {
                    signalReceivedAt[neighborNode] = currNodeTime + time;
                    pq.add(new Pair(signalReceivedAt[neighborNode], neighborNode));
                }
            }
        }
    }

}
