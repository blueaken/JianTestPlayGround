package lintcode.binarySearch.byValue;

public class CapacityToShipPackagesWithinDDays_LE_1011_BS_P1 {
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
    */
    public int shipWithinDays(int[] weights, int days) {
        //precisely start is min(weights[i]), end is max(weights[i]), but not big impact to the performance
        int start = 0, end = Integer.MAX_VALUE;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (checkOk(weights, days, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean checkOk(int[] weights, int days, int capacity) {
        int i = 0, j = 0, count = 0;
        while (i < weights.length) {

            if (weights[i] > capacity) {
                return false;
            }

            int sum = 0;
            while (j < weights.length && sum + weights[j] <= capacity) {
                sum += weights[j];
                j++;
            }
            count++;
            i = j;
        }
        return count <= days;
    }
}
