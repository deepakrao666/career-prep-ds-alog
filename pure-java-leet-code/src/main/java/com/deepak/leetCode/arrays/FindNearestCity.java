package com.deepak.leetCode.arrays;

public class FindNearestCity {

    public static void main(String[] args) {
        System.out.println(findNearestCity(
                new String[]{"aa", "bbb", "ccc"},
                new int[]{1, 1, 2},
                new int[]{1, 3, 4},
                "aa"
        ));
    }

    //Given cities, x, y cordinates of the cities, query.
    // Find the closest city.
    // If the x,y coordinate of the city matches, then return None.
    // Else return the city closest to the city in the query.
    // If two cities are equidistant, compare the length of the name of the city.
    // If the length is same, return the city which occurs first lexicographically.
    public static String findNearestCity(String[] cities, int[] x, int[] y, String city) {
        int index = -1;
        for (int i = 0; i < cities.length; i++) {
            if (city.equalsIgnoreCase(cities[i])) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return null;
        }
        int currX = x[index];
        int currY = y[index];
        Integer minDist = null;
        String closestCity = null;
        for (int i = 0; i < cities.length; i++) {
            if (i != index && (x[i] == currX || y[i] == currY)) {
                int dist = Math.abs(x[i] - currX) + Math.abs(y[i] - currY);
                if (minDist == null || dist < minDist) {
                    minDist = dist;
                    closestCity = cities[i];
                } else if (dist == minDist && cities[i].compareTo(closestCity) < 0) {
                    closestCity = cities[i];
                }
            }
        }
        return closestCity;
    }
}
