package com.deepak.leetCode.treesAndGraphs;

import java.util.*;

public class SwimInWaterDijkstrasAlgo {

    public int swimInWater(int[][] grid) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        int n = grid.length;

        queue.offer(new int[]{0, 0, grid[0][0]});

        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Set<Integer> set = new HashSet<>();

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            System.out.println(Arrays.toString(curr));
            int x = curr[0];
            int y = curr[1];
            int weight = curr[2];


            set.add(x * n + y);

            if (x == n - 1 && y == n - 1) {
                System.out.println(set);
                System.out.println(weight);
                return weight;
            }

            for (int[] dir : dirs) {

                int r = x + dir[0];
                int c = y + dir[1];

                if (r < 0 || c < 0 || r >= n || c >= n || set.contains(r * n + c))
                    continue;

                queue.offer(new int[]{r, c, Math.max(grid[r][c], weight)});
            }

            System.out.println("next");

        }

        System.out.println(set);
        System.out.println(n * n + 1);
        return n * n + 1;

    }
}
