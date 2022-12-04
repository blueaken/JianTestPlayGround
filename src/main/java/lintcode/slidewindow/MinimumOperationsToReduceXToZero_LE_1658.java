package lintcode.slidewindow;

public class MinimumOperationsToReduceXToZero_LE_1658 {
    /**
     12.04.2022
     - ref 东哥 post，solve by sliding window template
     - sliding window template works since all nums are positive, if mixed with negative numbers then need use prefix sum + hashtable, just like 560
     */
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int target = sum - x;

        int left = 0, right = 0;
        int windowSum = 0;
        int maxLen = Integer.MIN_VALUE;
        while (right < nums.length) {
            int r = nums[right];
            windowSum += r;
            right++;

            while (left < right && windowSum > target) {
                int l = nums[left];
                left++;
                windowSum -= l;
            }

            if (windowSum == target) {
                maxLen = Math.max(maxLen, right - left);
            }

        }
        return maxLen == Integer.MIN_VALUE ? -1 : nums.length - maxLen;
    }
}
