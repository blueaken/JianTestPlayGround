package lintcode.dynamicprogramming.lis;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence_LE_300_Greedy {
    /*
        10.17.2022
        read labuladong post and redo
        - bottom up DP
        ===================
        10.17.2022
        - improve with Binary Search after reading solution link, improve from O(N^2) to O(NLogN)
        - Tag: Greedy, Binary Search
    */
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur > sub.get(sub.size()-1)) {
                sub.add(cur);
            } else {
                //find the 1st pos of sub list that is greater or equal to the cur value
                int pos = bs(sub, cur);
                sub.set(pos, cur);
            }
        }
        return sub.size();
    }

    private int bs(List<Integer> list, int val) {
        int l = 0, r = list.size() - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            int cur = list.get(mid);
            if (cur == val) {
                return mid;
            }
            if (cur < val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
