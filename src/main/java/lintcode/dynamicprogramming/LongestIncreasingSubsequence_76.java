package lintcode.dynamicprogramming;

public class LongestIncreasingSubsequence_76 {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    //Idea: res[i] = Max(res[j] + 1, res[i]), j < i,
    //      ref - https://www.lintcode.com/problem/76/solution/17139
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //init
        int[] res = new int[nums.length];
        res[0] = 1;
        int global = 0;

        //dp
        for (int i = 1; i < nums.length; i++) {
            res[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    res[i] = Math.max(res[j]+1, res[i]);
                }
            }
            global = Math.max(res[i], global);
        }

        return global;
    }
}
