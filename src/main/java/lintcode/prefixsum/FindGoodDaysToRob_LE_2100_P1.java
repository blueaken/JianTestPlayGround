package lintcode.prefixsum;

import java.util.ArrayList;
import java.util.List;

public class FindGoodDaysToRob_LE_2100_P1 {
    /*
    ref - https://leetcode.com/problems/find-good-days-to-rob-the-bank/discuss/2581654/Java-Solution
    ===================================================
    nums -
    5  3  3  3  5  6  2

    non-increasing consecutive from left -
    0  1  2  3  0  0  1

    non-decreasing consecutive from right -
    0  4  3  2  1  0  0


    non-inc from left & non-dec from right for more than 2(time) days -
    0  0  c  c  0  0  0
    =================================
    P1 11.28.2022
    ref prev notes
    =================================
    */
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] nonIncLeft = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i-1]) {
                nonIncLeft[i] = nonIncLeft[i-1] + 1;
            } else {
                nonIncLeft[i] = 0;
            }
        }

        int[] nonDecRight = new int[n];
        for (int i = n-2; i >= 0; i--) {
            if (security[i] <= security[i+1]) {
                nonDecRight[i] = nonDecRight[i+1] + 1;
            } else {
                nonDecRight[i] = 0;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nonIncLeft[i] >= time && nonDecRight[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }
}
