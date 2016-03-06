package ninechapter.chapter4_dynamic_prgramming_1.longestincreasingsequence;

/**
 * Author: blueaken
 * Date: 3/3/16 12:29 PM
 */
public class Solution_DP {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public static int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //init state
        int[] f = new int[nums.length];
        int max = 0;

        //dp
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i] && f[j] + 1 > f[i]) {
                    f[i] = f[j] + 1;
                }
            }
            max = Math.max(max, f[i]);
        }

        return max;
    }

    public static void main(String[] args) {
//        int[] test = {4,2,4,5,3,7};
//        int[] test = {10,1,11,2,12,3,11};
        int[] test = {1,1,1,1,1,1,1};

        System.out.println(longestIncreasingSubsequence(test));
    }
}
