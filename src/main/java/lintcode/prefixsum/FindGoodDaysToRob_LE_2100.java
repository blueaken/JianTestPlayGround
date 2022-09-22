package lintcode.prefixsum;

import java.util.ArrayList;
import java.util.List;

public class FindGoodDaysToRob_LE_2100 {
    /*
    ref - https://leetcode.com/problems/find-good-days-to-rob-the-bank/discuss/2581654/Java-Solution
    ===================================================
    5  3  3  3  5  6  2

    non-incresing from left -
    0  1  2  3  3  3  4

    non-decreasing from right -
    4  4  3  2  1  0  0

    non-inc from left & non-dec from right for more than 2(time) days -
    0  0  c  c  0  0  0

    */
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;

        int[] nonIncFromLeft = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i-1]) {
                nonIncFromLeft[i] = nonIncFromLeft[i-1] + 1;
            }
        }

        int[] nonDecFromRight = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i+1]) {
                nonDecFromRight[i] = nonDecFromRight[i+1] + 1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nonIncFromLeft[i] >= time && nonDecFromRight[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }
}
