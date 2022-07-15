package lintcode.prefixsum;

import java.util.Arrays;

public class PlatesBetweenCandles_LE_2055 {
    /*
        ref - https://leetcode.com/problems/plates-between-candles/discuss/1549018/JavaC%2B%2BPython-Binary-Search-and-O(Q-%2B-N)-Solution
        - for each position count left candle numbers and right candle numbers, and count the the candle numbers, by these values to calculate the result

        Time - O(N + Q)
        Space - O(N)
     */
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        int[] nearestLeftCandle = new int[len];
        int[] nearestRightCandle = new int[len];
        int[] candleCount = new int[len];

        int candlePos = -1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '|') {
                candlePos = i;
            }
            nearestLeftCandle[i] = candlePos;
        }

        candlePos = -1;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                candlePos = i;
            }
            nearestRightCandle[i] = candlePos;
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '|') {
                count++;
            }
            candleCount[i] = count;
        }

        int[] ans = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];

            int leftCandle = nearestRightCandle[start];
            int rightCandle = nearestLeftCandle[end];

            if (leftCandle == -1 || rightCandle == -1) {
                ans[idx] = 0;
            } else {
                int dis = rightCandle - leftCandle;
                if (dis > 1) {
                    //total position number - candle numbers
                    ans[idx] = rightCandle - leftCandle + 1 - (candleCount[rightCandle] - candleCount[leftCandle] + 1);
                } else {
                    ans[idx] = 0;
                }
            }
            idx++;
        }
        return ans;
    }
/*
                        0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18  19  20

                        *  *  *  |  *  *  |  *  *  *   *   *   |   *   *   |   |   *   *   |   *
nearest right candle:   3  3  3  3  6  6  6  12 12 12  12 12  12  15  15  15   16  19  19  19  -
nearest left candle:    -  -  -  3  3  3  6  6  6  6   6  6   12  12  12  15  16  16  16   19  19
candle count:           0  0  0  1  1  1  2  2  2  2   2  2    3   3   3   4   5   5   5   6   6
*/

    public static void main(String[] args) {
        PlatesBetweenCandles_LE_2055 solution = new PlatesBetweenCandles_LE_2055();
//        String s = "***|**|*****|**||**|*";
//        int[][] queries = {{2,5},{5,13},{11,20}}; //{0, 5, 4}

        String s = "*|*|||";
        int[][] queries = {{0,0},{1,3}}; //{0, 1}

        System.out.println(Arrays.toString(solution.platesBetweenCandles(s, queries)));
    }



}
