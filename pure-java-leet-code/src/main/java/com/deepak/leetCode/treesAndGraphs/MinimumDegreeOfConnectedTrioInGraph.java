package com.deepak.leetCode.treesAndGraphs;

import java.util.Arrays;

public class MinimumDegreeOfConnectedTrioInGraph {

    // TODO : doordash

    public int minTrioDegree(int n, int[][] edges) {
        // to store edge information
        boolean[][] graph = new boolean[n + 1][n + 1];
        //to store inDegrees to a node(NOTE: here inDegree and outDegree are same because it is Undirected graph)
        int[] inDegree = new int[n + 1];

        for (int[] row : edges) {
            graph[row[0]][row[1]] = true;
            graph[row[1]][row[0]] = true;

            inDegree[row[0]]++;
            inDegree[row[1]]++;
        }

        int result = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++ ){

                // if there is edge
                if(graph[i][j]){

                    for(int k = j + 1; k<=n ; k++){

                        // if [i] and [j] have edge
                        // then check to see if there is third vertex
                        if(graph[i][k] && graph[j][k]){

                            // if found
                            // calculate degree

                            // minimum value for degree is 2
                            // 3 vertex * 2 == 6
                            // matched - 6

                            int matched = inDegree[i] + inDegree[j] + inDegree[k] - 6;

                            result = Math.min(result, matched);
                        }
                    }

                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
