package com.deepak.leetCode.design;

import java.util.*;

public class DesignALeaderBoard {

    Map<Integer, Integer> scores;
    TreeMap<Integer, Integer> sortedScores;

    public DesignALeaderBoard() {
        this.scores = new HashMap<>();
        this.sortedScores = new TreeMap<>(Collections.reverseOrder());
    }

    public void addScore(int playerId, int score) {

        if (!this.scores.containsKey(playerId)) {
            this.scores.put(playerId, score);
            this.sortedScores.put(score, this.sortedScores.getOrDefault(score, 0) + 1);
        } else {

            int preScore = this.scores.get(playerId);
            int playerCount = this.sortedScores.get(preScore);


            // If no player has this score, remov it from the tree.
            if (playerCount == 1) {
                this.sortedScores.remove(preScore);
            } else {
                this.sortedScores.put(preScore, playerCount - 1);
            }

            // Updated score
            int newScore = preScore + score;
            this.scores.put(playerId, newScore);
            this.sortedScores.put(newScore, this.sortedScores.getOrDefault(newScore, 0) + 1);
        }
    }

    public int top(int K) {

        int count = 0;
        int sum = 0;

        // In-order traversal over the scores in the TreeMap
        for (Map.Entry<Integer, Integer> entry: this.sortedScores.entrySet()) {

            // Number of players that have this score.
            int times = entry.getValue();
            int score = entry.getKey();

            for (int i = 0; i < times; i++) {
                sum += score;
                count++;

                // Found top-K scores, break.
                if (count == K) {
                    break;
                }
            }

            // Found top-K scores, break.
            if (count == K) {
                break;
            }
        }

        return sum;
    }

    public void reset(int playerId) {
        int preScore = this.scores.get(playerId);
        this.sortedScores.put(preScore, this.sortedScores.get(preScore) - 1);
        if (this.sortedScores.get(preScore) == 0) {
            this.sortedScores.remove(preScore);
        }

        this.scores.remove(playerId);
    }

}
