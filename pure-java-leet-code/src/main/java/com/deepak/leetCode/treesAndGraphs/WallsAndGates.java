package com.deepak.leetCode.treesAndGraphs;

import java.util.*;

public class WallsAndGates {

    static final int EMPTY = Integer.MAX_VALUE;
    static final int GATE = 0;
    static final int WALL = -1;

    List<List<Integer>> DIRECTIONS = Arrays.asList(
            Arrays.asList(1, 0),
            Arrays.asList(-1, 0),
            Arrays.asList(0, 1),
            Arrays.asList(0, -1)
    );

    public static void main(String[] args) {
        WallsAndGates wallsAndGates = new WallsAndGates();
        int[][] mat = new int[][]{{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        wallsAndGates.wallsAndGates(mat);
    }

    public void wallsAndGates(int[][] rooms) {

        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;

        Queue<List<Integer>> queueOfGates = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    queueOfGates.add(Arrays.asList(i, j));
                }
            }
        }

        System.out.println(queueOfGates);
        System.out.println("--");
        while (!queueOfGates.isEmpty()) {


            List<Integer> point = queueOfGates.poll();

            int row = point.get(0);
            int col = point.get(1);

            DIRECTIONS.forEach(dir -> {
                int r = row + dir.get(0);
                int c = col + dir.get(1);
                boolean dontAllow = (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY);
                if (!dontAllow) {
                    System.out.println("row = " + row + " col = " + col);
                    System.out.println("r = " + r + " c = " + c);
                    rooms[r][c] = rooms[row][col] + 1;

                    queueOfGates.add(Arrays.asList(r, c));
                }
            });
            System.out.println(queueOfGates);
            System.out.println("----");

        }


    }
}