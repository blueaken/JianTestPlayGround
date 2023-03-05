package lintcode.binarysearch.labuladong;

public class FindFirstAndLastPositionOfElementInSortedArray_LE_34_LeftLessRight_P1 {
    /**
     12.08.2022
     ref 东哥 BS template
     =================
     12.09.2022
     refactor the template with range check to improve efficiency
     =================
     12.09.2022
     refactor the template to 左闭右开 "left < right"
     =================
     3.5.2023
     P1 with 东哥 [left, right) template
     */
    public int[] searchRange(int[] nums, int target) {
        int r0 = left_bound(nums, target);
        int r1 = right_bound(nums, target);
        return new int[]{r0, r1};
    }

    private int left_bound(int[] nums, int target) {
        int n = nums.length;
        // check invalid
        if (n == 0 || nums[0] > target || nums[n-1] < target) {
            return -1;
        }

        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == n) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    private int right_bound(int[] nums, int target) {
        int n = nums.length;
        // check invalid
        if (n == 0 || nums[0] > target || nums[n-1] < target) {
            return -1;
        }

        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left - 1 < 0) {
            return -1;
        }
        return nums[left-1] == target ? left-1 : -1;
    }
}
