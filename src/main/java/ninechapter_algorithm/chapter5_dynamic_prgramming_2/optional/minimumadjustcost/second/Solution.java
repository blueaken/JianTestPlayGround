package ninechapter_algorithm.chapter5_dynamic_prgramming_2.optional.minimumadjustcost.second;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 7/9/16 13:31
 */
public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() == 0) {
            return -1;
        }

        //init
        int len = A.size();
        int[][] res = new int[len][101];
        for (int i = 1; i <= 100; i++) {
            res[0][i] = Math.abs(i - A.get(0));
        }

        //dp
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= 100; j++) {
                res[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= 100; k++) {
                    if (Math.abs(j - k) > target) {
                        continue;
                    }
                    res[i][j]
                            = Math.min(Math.abs(j - A.get(i)) + res[i -1][k] , res[i][j]);
                }
            }
        }

        //find min
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            min = Math.min(res[len - 1][i], min);
        }
        return min;
    }
}
