package com.deepak.leetCode.arrays;

import java.util.Arrays;
import java.util.TreeMap;

public class MostProfitAssigningWork {

    // TODO : doordash

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int n = difficulty.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < n; i ++){
            if(!map.containsKey(difficulty[i])){
                map.put(difficulty[i], profit[i]);
            }else {
                if(map.get(difficulty[i]) < profit[i]){
                    map.put(difficulty[i], profit[i]);
                }
            }
        }

        int maxProfit = 0;

        for(Integer diff : map.keySet()){
            maxProfit = Math.max(map.get(diff), maxProfit);
            map.put(diff, maxProfit);
        }

        Arrays.sort(worker);
        maxProfit = 0;

        for(Integer workerDiff : worker){

            if(map.floorKey(workerDiff) != null){
                maxProfit += map.get(map.floorKey(workerDiff));
            }
        }
        return maxProfit;
    }


//    public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
//        int n = difficulty.length;
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//
//        for (int i = 0; i < n; i++) {
//            if (!treeMap.containsKey(difficulty[i])) {
//                treeMap.put(difficulty[i], profit[i]);
//            } else {
//                //same difficulty, store higher profit
//                if (treeMap.get(difficulty[i]) < profit[i]) {
//                    treeMap.put(difficulty[i], profit[i]);
//                }
//            }
//        }
//
//        // store max profit with difficulty equals or below current difficulty
//        // in case lower difficulty has higher profit
//        int maxProfit = 0;
//        for (int difficulties : treeMap.keySet()) {
//
//            maxProfit = Math.max(treeMap.get(difficulties), maxProfit);
//
//            treeMap.put(difficulties, maxProfit);
//        }
//
//        Arrays.sort(worker);
//        int res = 0;
//        for (int workerDifficulty : worker) {
//            // if greatest key less than or equal to given key from the difficulty exists
//            if (treeMap.floorKey(workerDifficulty) != null) {
//                res += treeMap.get(treeMap.floorKey(workerDifficulty));
//            }
//        }
//
//        return res;
//    }



}
