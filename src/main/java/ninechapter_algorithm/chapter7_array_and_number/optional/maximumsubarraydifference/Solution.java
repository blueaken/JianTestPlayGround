package ninechapter_algorithm.chapter7_array_and_number.optional.maximumsubarraydifference;

/**
 * Author: blueaken
 * Date: 5/29/16 11:06
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }

        int len = nums.length;
        int[] leftMax = new int[len];
        int[] leftMin = new int[len];
        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;
        int localMin = 0;
        int globalMin = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            localMax = Math.max(localMax + nums[i], nums[i]);
            globalMax = Math.max(localMax, globalMax);
            leftMax[i] = globalMax;

            localMin = Math.min(localMin + nums[i], nums[i]);
            globalMin = Math.min(localMin, globalMin);
            leftMin[i] = globalMin;
        }

        int[] rightMax = new int[len];
        int[] rightMin = new int[len];
        localMax = 0;
        globalMax = Integer.MIN_VALUE;
        localMin = 0;
        globalMin = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            localMax = Math.max(localMax + nums[i], nums[i]);
            globalMax = Math.max(localMax, globalMax);
            rightMax[i] = globalMax;

            localMin = Math.min(localMin + nums[i], nums[i]);
            globalMin = Math.min(localMin, globalMin);
            rightMin[i] = globalMin;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            int leftMaxDiff = Math.abs(leftMax[i] - rightMin[i + 1]);
            int rightMaxDiff = Math.abs(rightMax[i + 1] - leftMin[i]);
            max = Math.max(Math.max(leftMaxDiff, rightMaxDiff), max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1,2,-3,1};
        System.out.println(solution.maxDiffSubArrays(test));
    }
}
