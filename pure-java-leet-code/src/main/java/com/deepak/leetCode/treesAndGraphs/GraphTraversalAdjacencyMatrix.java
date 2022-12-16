package com.deepak.leetCode.treesAndGraphs;

public class GraphTraversalAdjacencyMatrix {

    private static final int[][] matrix = {
            {0,1,0,0,1},
            {1,0,1,0,0},
            {0,1,0,1,0},
            {0,0,1,0,1},
            {1,0,0,1,0},
    };

    public static void main(String[] args) {
        bfs(matrix);
    }

    private static void bfs(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] visited = new boolean[m];

        for(int i = 0; i< m;i++){
            if(!visited[i]){

                System.out.println(i);
                visited[i] = true;

                for(int j = 0; j < n ; j++){
                    if( matrix[i][j] == 1 && !visited[matrix[i][j]]){
                        visited[matrix[i][j]] = true;
                        System.out.print(matrix[i][j] + " ");
                    }
                }
            }

        }

    }

}
