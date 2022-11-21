package lintcode.binarysearch.byValue;

public class CapacityToShipPackagesWithinDDays_LE_1011_BS {
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
    */
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int left = 0, right = Integer.MAX_VALUE; //at most 32 times, to be more precisely, left is max(weights[i]), right is sum(weights[i], but of not big improve to the time performance)

        //双闭区间，收敛解
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (checkOk(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    //group by greedy
    private boolean checkOk(int[] weights, int days, int val) {
        int i = 0, j = 0, count = 0;
        while (i < weights.length) {
            //tricky, no need to process if val less than any element
            if (weights[i] > val) {
                return false;
            }

            int sum = 0;
            while (j < weights.length && sum + weights[j] <= val) {
                sum += weights[j];
                j++;
            }
            count++;
            i = j; //i value should be j in the next iteration
        }
        return count <= days;
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays_LE_1011_BS solution = new CapacityToShipPackagesWithinDDays_LE_1011_BS();
//        int[] weights = {7,2,5,10,8};
//        int days = 2;
//        //18
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        //15

        System.out.println(solution.shipWithinDays(weights, days));
    }
}
