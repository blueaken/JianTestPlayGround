package ninechapter_algorithm.chapter4_dynamic_prgramming_1.longestincreasingsequence.third;

/**
 * Author: blueaken
 * Date: 7/3/16 09:50
 */
public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //init
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = 1;
        }

        //dp
        int max = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    res[i] = Math.max(res[j] + 1, res[i]);
                }
            }
            max = Math.max(res[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] test = {1,1,1};
        int[] test = {9,3,6,2,7};

        Solution solution = new Solution();
        System.out.println(solution.longestIncreasingSubsequence(test));
    }
}
