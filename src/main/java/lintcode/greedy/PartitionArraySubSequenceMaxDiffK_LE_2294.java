package lintcode.greedy;

import java.util.Arrays;

public class PartitionArraySubSequenceMaxDiffK_LE_2294 {
    /*
        ref - https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/discuss/2112182/FULLY-EXPLAINED!!
        - greedy sort
        - O(NLogN)
    */
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1; //initially our whole array is a subsequence for us, and the answer is at least 1
        int min = nums[0], max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = nums[i];
            if (max - min > k) {
                ans++;
                min = nums[i]; //start a new subsequence
            }
        }
        return ans;
    }
}
