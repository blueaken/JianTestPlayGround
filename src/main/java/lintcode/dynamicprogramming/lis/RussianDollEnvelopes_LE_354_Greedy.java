package lintcode.dynamicprogramming.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RussianDollEnvelopes_LE_354_Greedy {
    /*
    10.17.2022
    read labuladong post and redo
    - bottom up DP
    - 1st INC sort on width, if width equals then DEC sort on height
    - find the LIS on the sorted height, which is the answer
     ===================
    10.17.2022
    - improve with Binary Search after reading solution link, improve from O(N^2) to O(NLogN)
    - Tag: Greedy, Binary Search
    */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            int diff = a[0] - b[0];
            if (diff == 0) {
                return b[1] - a[1];
            }
            return diff;
        });

        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        //find the LIS of heights array with greedy & binary search
        return lengthOfLIS(heights);
    }

    private int lengthOfLIS(int[] nums) {
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
