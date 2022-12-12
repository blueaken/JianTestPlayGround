package lintcode.binarysearch.labuladong.variant;

public class PeakIndexInAMountainArray_LE_852 {
    /**
     12.12.2022
     - almost same as 162.
     */
    public int peakIndexInMountainArray(int[] nums) {
        int left = 1, right = nums.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean r1 = isBiggerThanLeft(nums, mid);
            boolean r2 = isBiggerThanRight(nums, mid);
            if (r1 && r2) {
                return mid;
            } else if (r1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private boolean isBiggerThanLeft(int[] nums, int idx) {
        return nums[idx] > nums[idx-1];
    }

    private boolean isBiggerThanRight(int[] nums, int idx) {
        return nums[idx] > nums[idx+1];
    }
}
