package com.deepak.leetCode.treesAndGraphs;

import java.util.*;
import java.util.stream.Collectors;

public class SnakeAndLadder {

    public static void main(String[] args) {

    }

    public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {

        Map<Integer, Integer> ladderMap = new HashMap<>();
        ladders.forEach(e -> ladderMap.put(e.get(0), e.get(1)));

        Map<Integer, Integer> snakeMap = new HashMap<>();
        snakes.forEach(e -> snakeMap.put(e.get(0), e.get(1)));

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(1);
        int turns = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            System.out.println("turns = " + turns + "size = " + size);
            System.out.println(queue);
            while (size-- > 0) {

                int position = queue.poll();

                if (position == 100)
                    return turns;

                if (!visited.contains(position)) {
                    visited.add(position);

                    int nextMax = Math.min(position + 6, 100);

                    for (int i = position + 1; i <= nextMax; i++) {

                        if (ladderMap.containsKey(i)) {
                            queue.add(ladderMap.get(i));
                        } else if (snakeMap.containsKey(i)) {
                            queue.add(snakeMap.get(i));
                        } else {
                            queue.add(i);
                        }
                    }
                }
            }

            turns++;
        }
        return -1;
    }

}
