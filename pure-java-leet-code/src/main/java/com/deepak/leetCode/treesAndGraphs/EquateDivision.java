package com.deepak.leetCode.treesAndGraphs;

import java.util.*;

public class EquateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {

            List<String> singleEquation = equations.get(i);
            String dividend = singleEquation.get(0);
            String divisor = singleEquation.get(1);

            double quotient = values[i];

            if (!graph.containsKey(dividend)) {
                graph.put(dividend, new HashMap<>());
            }
            if (!graph.containsKey(divisor)) {
                graph.put(divisor, new HashMap<>());
            }

            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1 / quotient);
        }

        System.out.println(graph);
        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> singleQuery = queries.get(i);

            String dividend = singleQuery.get(0);
            String divisor = singleQuery.get(1);


            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                results[i] = -1;
            } else if (Objects.equals(dividend, divisor)) {
                results[i] = 1;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = backTrack(graph, dividend, divisor, 1, visited);
            }
        }
        return results;
    }

    private double backTrack(HashMap<String, HashMap<String, Double>> graph, String currNode, String targetNode, double accProduct, Set<String> visited) {
        visited.add(currNode);
        double ret = -1.0;

        Map<String, Double> neighbours = graph.get(currNode);

        if (neighbours.containsKey(targetNode)) {
            ret = accProduct * neighbours.get(targetNode);
        } else {


            for (Map.Entry<String, Double> entry : neighbours.entrySet()) {

                String nextNode = entry.getKey();

                if (visited.contains(nextNode)) {
                    continue;
                }

                double newProduct = accProduct * entry.getValue();

                ret = backTrack(graph, nextNode, targetNode, newProduct, visited);

                if(ret == -1.0){
                    break;
                }
            }
        }

        // unmark for backtracking
        visited.remove(currNode);

        return ret;
    }

}
