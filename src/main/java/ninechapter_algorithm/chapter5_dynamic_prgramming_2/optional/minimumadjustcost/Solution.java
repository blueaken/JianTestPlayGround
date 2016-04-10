package ninechapter_algorithm.chapter5_dynamic_prgramming_2.optional.minimumadjustcost;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 4/9/16 7:44 PM
 */
public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public static int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() == 0) {
            return 0;
        }

        //init
        int n = A.size();
        int [][] res = new int[n][101];
        for (int i = 1; i <= 100; i++) {
            res[0][i] = Math.abs(i - A.get(0));
        }

        //dp
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 100; j++) {
                res[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= 100; k++) {
                    if (Math.abs(j - k) > target) {
                        continue;
                    }
                    res[i][j] = Math.min((Math.abs(j - A.get(i)) + res[i-1][k]), res[i][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            min = Math.min(res[n-1][i], min);
        }
        return min;
    }

    public static void main(String[] args) {
        int target = 1;
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(4);
        A.add(2);
        A.add(3);

        System.out.println(MinAdjustmentCost(A, target));
    }
}
