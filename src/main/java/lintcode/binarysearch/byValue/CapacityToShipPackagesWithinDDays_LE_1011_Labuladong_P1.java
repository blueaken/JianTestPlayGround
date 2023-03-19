package lintcode.binarysearch.byValue;

public class CapacityToShipPackagesWithinDDays_LE_1011_Labuladong_P1 {
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
        ================================
        3.19.2023
        P1 东哥模板
    */
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 1;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            // return number of days needed to ship all packages with the capacity mid
            int x = f(weights, mid);
            if (x == days) {
                // search for left boundary
                right = mid;
            } else if (x < days) {
                // need smaller capacity to make f() return bigger days
                right = mid;
            } else {
                // need bigger capacity to make f() return smaller days
                left = mid + 1;
            }
        }
        return left;
    }

    private int f(int[] weights, int k) {
        int days = 0;
        for (int i = 0; i < weights.length;) {
            int cap = k;
            while (i < weights.length) {
                if (cap < weights[i]) {
                    break;
                }
                cap -= weights[i];
                i++;
            }
            days++;
        }
        return days;
    }
}
