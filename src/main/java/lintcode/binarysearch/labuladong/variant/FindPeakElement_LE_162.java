package lintcode.binarysearch.labuladong.variant;

public class FindPeakElement_LE_162 {
    /**
     12.12.2022
     ref 东哥 post & prev notes
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
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
        //note nums[-1] = negative infinity
        return idx == 0 || (nums[idx] > nums[idx-1]);
    }

    private boolean isBiggerThanRight(int[] nums, int idx) {
        //note nums[n] = negative infinity
        return idx == nums.length - 1 || (nums[idx] > nums[idx+1]);
    }
}
