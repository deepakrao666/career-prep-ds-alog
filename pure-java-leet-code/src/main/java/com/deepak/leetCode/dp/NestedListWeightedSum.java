package com.deepak.leetCode.dp;


import com.deepak.leetCode.NestedInteger;
import java.util.List;

public class NestedListWeightedSum {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        for (NestedInteger i : nestedList) {
            sum += calcDepth(i, 1);
        }
        return sum;
    }

    private int calcDepth(NestedInteger nInt, int depth) {

        if (nInt.isInteger()) {
            return depth * nInt.getInteger();
        } else {
            int sum = 0;
            for (NestedInteger i : nInt.getList()) {
                sum += calcDepth(i, depth + 1);
            }
            return sum;
        }
    }


}
