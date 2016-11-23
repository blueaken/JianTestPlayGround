package ninechapter_algorithm.chapter4_dynamic_prgramming_1.longestincreasingsequence.second;

/**
 * Author: blueaken
 * Date: 4/6/16 4:16 PM
 */
public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public static int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //init
        int n = nums.length;
        int[] res = new int[n];
        int max = 0;

        //dp
        for (int i = 1; i < n; i++) {
            res[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]){
                    res[i] = Math.max(res[j] + 1, res[i]);
                }
            }
            max = Math.max(max, res[i]);
        }

        return max;
    }

    public static void main(String[] args) {
//        int[] test = {5,4,1,2,3};
        int[] test = {4,2,4,5,3,7};
//        int[] test = {10,1,11,2,12,3,11};
//        int[] test = {1,1,1,1,1,1,1};

        System.out.println(longestIncreasingSubsequence(test));
    }
}
