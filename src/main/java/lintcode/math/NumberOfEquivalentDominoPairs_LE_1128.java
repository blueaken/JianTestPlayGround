package lintcode.math;

import java.util.HashMap;
import java.util.Map;

public class NumberOfEquivalentDominoPairs_LE_1128 {
    /*
        - for each dominoes, generate key to ease the calculation
        - f(domino) = min(d[0], d[1]) * 10 + max(d[0], d[1]) For each domino d, calculate min(d[0], d[1]) * 10 + max(d[0], d[1]) This will put the smaller number on the left and bigger one on the right (in decimal).
        - the number of equivalent pair is the combination of 2, the formula is: n * (n - 1) / 2
        - ref - https://leetcode.com/problems/number-of-equivalent-domino-pairs/discuss/340022/JavaC%2B%2BPython-Easy-and-Concise
    */
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>(); //key, count
        for (int[] domino : dominoes) {
            int key = Math.min(domino[0], domino[1]) * 10 + Math.max(domino[0], domino[1]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int res = 0;
        for (Integer v : map.values()) {
            res += v * (v - 1) / 2;
        }
        return res;
    }
}
