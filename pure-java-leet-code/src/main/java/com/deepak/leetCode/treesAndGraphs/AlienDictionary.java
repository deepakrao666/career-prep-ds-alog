package com.deepak.leetCode.treesAndGraphs;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        final String s = alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
        System.out.println(s + "-" + s.isEmpty());

        System.out.println("---------------------------------");
        final String s2 = alienOrder(new String[]{"z", "x", "z"});
        System.out.println(s2 + "-" + s2.isEmpty());

    }

    // ---------------------------------




    public static String alienOrder(String[] words) {
         Map<Character, List<Character>> reverseAdjList = new LinkedHashMap<>();
         Map<Character, Boolean> seen = new HashMap<>();
         StringBuilder output = new StringBuilder();

        // Step 0: Put all unique letters into reverseAdjList as keys.
        for (String word : words) {
            for (char c : word.toCharArray()) {
                reverseAdjList.putIfAbsent(c, new ArrayList<>());
            }
        }

        System.out.println("Step 1");
        System.out.println(reverseAdjList);

        // Step 1: Find all edges and add reverse edges to reverseAdjList.
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // Check that word2 is not a prefix of word1.
            if (word1.length() >= word2.length() && word1.startsWith(word2)) {
                System.out.println("invalid word");
                return "";
            }
            // Find the first non match and insert the corresponding relation.
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    reverseAdjList.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }

        System.out.println("Step 2");
        System.out.println(reverseAdjList);
        System.out.println(reverseAdjList.keySet());

        // Step 2: DFS to build up the output list.
        for (Character c : reverseAdjList.keySet()) {
            boolean result = dfs(c, seen, reverseAdjList, output);
            if (!result) {
                System.out.println("invalid 2 word");
                return "";}
        }

        return output.toString();
    }

    // Return true iff no cycles detected.
    private static boolean dfs(Character c, Map<Character, Boolean> seen, Map<Character, List<Character>> reverseAdjList, StringBuilder output) {
        if (seen.containsKey(c)) {
            return seen.get(c); // If this node was grey (false), a cycle was detected.
        }

        seen.put(c, false);
        for (Character next : reverseAdjList.get(c)) {
            boolean result = dfs(next, seen, reverseAdjList, output);
            if (!result) return false;
        }
        seen.put(c, true);
        output.append(c);
        return true;
    }

}

