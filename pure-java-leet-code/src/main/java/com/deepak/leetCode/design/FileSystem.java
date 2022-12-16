package com.deepak.leetCode.design;

import java.util.*;

public class FileSystem {
    class TrieNode {
        String name;
        int val = -1;
        Map<String, TrieNode> childMap = new HashMap<>();

        TrieNode(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "name='" + name + '\'' +
                    ", val=" + val +
                    ", childMap=" + childMap +
                    '}';
        }
    }

    TrieNode root;

    public FileSystem() {
        this.root = new TrieNode("");
    }

    public boolean createPath(String path, int value) {

        String[] split = path.split("/");
        System.out.println(Arrays.toString(split));

        TrieNode curr = root;

        for (int i = 1; i < split.length; i++) {

            String word = split[i];

            if (!curr.childMap.containsKey(word)) {

                if (i == split.length - 1) {
                    curr.childMap.put(word, new TrieNode(word));
                } else {
                    return false;
                }
                System.out.println(curr.childMap);
            }

            curr = curr.childMap.get(word);
        }

        System.out.println(curr);

        if (curr.val != -1) {
            return false;
        }

        curr.val = value;

        return true;
    }


    public int get(String path) {
        String[] split = path.split("/");
        System.out.println(Arrays.toString(split));
        TrieNode curr = root;

        for(int i = 1; i < split.length; i++){

            String word = split[i];
            System.out.println(curr.childMap);

            if(!curr.childMap.containsKey(word)){
                return -1;
            }

            curr = curr.childMap.get(word);

        }
        System.out.println(curr);
        return curr.val;
    }
}
