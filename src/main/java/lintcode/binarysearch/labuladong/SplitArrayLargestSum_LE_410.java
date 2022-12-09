package lintcode.binarysearch.labuladong;

public class SplitArrayLargestSum_LE_410 {
    /**
     P1 12.09.2022
     exactly the same as 1011
     solve by 东哥 BS template
     */
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 1;
        for (int i : nums) {
            left = Math.max(left, i);
            right += i;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(nums, mid) <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //f(x) - when max subarray sum is x, the number of subarray groups
    private int f(int[] nums, int x) {
        int groups = 0;
        int i = 0, j = 0;
        while (i < nums.length) {
            int cap = x;
            while (j < nums.length) {
                if (nums[j] > cap) {
                    break;
                }
                cap -= nums[j];
                j++;
            }
            groups++;
            i = j;
        }
        return groups;
    }
}
