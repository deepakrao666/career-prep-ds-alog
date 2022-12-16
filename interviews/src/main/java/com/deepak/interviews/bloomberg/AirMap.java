package com.deepak.interviews.bloomberg;

import java.util.*;

/*

 Implement a class called AirMap that has two methods:

 1- add_route(start, destination)
     - adds a ONE WAY connecting flight from start to destination

 2- print_all_routes(start, destination)
     - prints all possible routes from start to destination irrespective of hops


 Given the following flight routes, print all possible routes between the airports C and D

   A ----> B
   B ----> A
   A ----> C
   A ----> C
   A ----> C
   A ----> C
   C ----> A
   A ----> D
   D ----> A
   B ----> C
   A ----> D
   D ----> A
   B ----> C
   A ----> D
   D ----> A
   B ----> C
   C ----> B
   B ----> D
   D ----> B

 Expected output C D:

 //   C,A,B,D,
 //   C,A,D,
 //   C,B,A,D,
 //   C,B,D,
   */
public class AirMap {


    public static void main(String[] args) {
        AirMap airMap = new AirMap();

        airMap.addRoute("A", "B");
        airMap.addRoute("A", "C");
        airMap.addRoute("A", "D");
        airMap.addRoute("B", "A");
        airMap.addRoute("B", "C");
        airMap.addRoute("B", "D");
        airMap.addRoute("C", "A");
        airMap.addRoute("C", "B");
//        airMap.addRoute("C", "D");
        airMap.addRoute("D", "A");
        airMap.addRoute("D", "B");
        airMap.addRoute("D", "C");

        airMap.printGraph();


        System.out.println(airMap.routes("C", "D"));
    }


    Map<String, List<String>> graph;

    public AirMap() {
        graph = new HashMap<>();
    }

    public void addRoute(String start, String dest) {
        if (!graph.containsKey(start)) {
            graph.put(start, new LinkedList<>());
        }

        graph.get(start).add(dest);
    }

    public List<List<String>> routes(String start, String dest) {

        LinkedList<List<String>> res = new LinkedList<>();

        Map<String, Boolean> visitedMap = new HashMap<>();
        graph.forEach((k, v) -> visitedMap.put(k, null));


        LinkedList<String> path = new LinkedList<>();
        path.addLast(start);

        printAllPaths(start, dest, visitedMap, path, res);


        return res;
    }

    private void printAllPaths(String start, String dest, Map<String, Boolean> visitedMap, LinkedList<String> path, LinkedList<List<String>> res) {

        if (start.equals(dest)) {
            res.add(new ArrayList<>(path));
            return;
        }

        visitedMap.put(start, true);

        for (String route : graph.get(start)) {
            if (visitedMap.get(route) == null || !visitedMap.get(route)) {
                path.add(route);
                printAllPaths(route, dest, visitedMap, path, res);
                path.remove(route);
            }
        }

        visitedMap.put(start, false);

    }


    public void printGraph() {
        System.out.println(graph);
    }
}
