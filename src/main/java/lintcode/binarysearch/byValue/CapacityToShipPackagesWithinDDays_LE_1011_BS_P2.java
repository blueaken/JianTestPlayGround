package lintcode.binarysearch.byValue;

public class CapacityToShipPackagesWithinDDays_LE_1011_BS_P2 {
    /*
        - almost same as 410
        - gut feeling is dp
        - ref 花花 https://www.youtube.com/watch?v=_k-Jb4b7b_0 & Huifeng Guan https://www.youtube.com/watch?v=-F2ysRiSTvk
        - dp[i][j]: i - number of groups, j - number of elements involved, from start of array
        - dp[1][j] = sum(0 ... j), when only 1 group, the ans is just sum every element invloved
        - dp[i][j] = min{max(dp[i-1][k], sum(k+1 ... j))}, 0 <= k < j, basically try every cutting point and find the minimum largest sum
        - Huifeng Guan讲得思路更清楚，但不做讲义；花花的讲义做得好。
        - Time is O(mn^2), Space is O(mn), will TLE for sure.
        - try Binary Search later
        ==========================================
        - Binary Search, 双闭区间，收敛解
        - checkOk method用greedy分组，看是否Ok
        ==========================================
        P1
        - Type: Binary Search By Value
        - check previous notes
        ==========================================
        P2 12.09.2022
        - redo with labuladong BS left bound template
        - note 东哥模板区间是严格的左闭右开，对左边界的选择需要确认
    */
    public int shipWithinDays(int[] weights, int days) {
        //precisely left is max(weights[i]), right is sum(weights[i]), but not big impact to the performance
        int left = 0, right = Integer.MAX_VALUE;

        // int left = 0;
        // int right = 1;
        for (int w : weights) {
            left = Math.max(left, w);
            // right += w;
        }

        // //we are looking for min weight capacity, so use left bound template of the binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // f(x) - when capacity is x, the total days need to ship all packages
    int f(int[] weight, int x) {
        int days = 0;
        int i = 0, j = 0;
        while (i < weight.length) {
            int cap = x;
            while (j < weight.length) {
                if (weight[j] > cap) {
                    break;
                }
                cap -= weight[j];
                j++;
            }
            i = j;
            days++;
        }
        return days;
    }
}
