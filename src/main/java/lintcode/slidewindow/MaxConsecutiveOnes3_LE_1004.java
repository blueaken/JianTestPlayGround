package lintcode.slidewindow;

public class MaxConsecutiveOnes3_LE_1004 {
    /**
     12.05.2022
     solve by 东哥 sliding window template
     */
    public int longestOnes(int[] nums, int k) {
        int res = 0;

        int left = 0, right = 0;
        int windowOneLen = 0;
        while (right < nums.length) {
            int r = nums[right];
            right++;

            if (r == 1) {
                windowOneLen++;
            }

            //curLen is right - left
            while (right - left - windowOneLen > k) {
                //if k cannot convert all 0s to 1s of the current subarray, then we need shrink the window
                int l = nums[left];
                left++;

                if (l == 1) {
                    windowOneLen--;
                }
            }

            //at this position, right - left is a valid subarray of all 1s (with the help of at most k flips)
            res = Math.max(res, right - left);
        }
        return res;
    }
}
