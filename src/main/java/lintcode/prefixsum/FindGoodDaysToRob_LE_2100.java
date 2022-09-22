package lintcode.prefixsum;

import java.util.ArrayList;
import java.util.List;

public class FindGoodDaysToRob_LE_2100 {
    /*
    ref - https://leetcode.com/problems/find-good-days-to-rob-the-bank/discuss/2581654/Java-Solution
    ===================================================
    5  3  3  3  5  6  2

    non-increasing consecutive from left -
    0  1  2  3  0  0  1

    non-decreasing consecutive from right -
    0  4  3  2  1  0  0


    non-inc from left & non-dec from right for more than 2(time) days -
    0  0  c  c  0  0  0

    */
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;

        int[] nonIncConsecFromLeft = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i-1]) {
                nonIncConsecFromLeft[i] = nonIncConsecFromLeft[i-1] + 1;
            } else {
                nonIncConsecFromLeft[i] = 0;
            }
        }

        int[] nonDecConsecFromRight = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i+1]) {
                nonDecConsecFromRight[i] = nonDecConsecFromRight[i+1] + 1;
            } else {
                nonDecConsecFromRight[i] = 0;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nonIncConsecFromLeft[i] >= time && nonDecConsecFromRight[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }
}
