package lintcode.binarysearch.labuladong;

public class FindFirstAndLastPositionOfElementInSortedArray_LE_34_WithRangeCheck {
    /**
     12.08.2022
     ref 东哥 BS template
     =================
     12.09.2022
     refactor the template with range check to improve efficiency
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int r0 = left_bound(nums, target);
        int r1 = right_bound(nums, target);

        return new int[]{r0, r1};
    }

    private int left_bound(int[] nums, int target) {
        int n = nums.length;
        //check if out of boundary
        if (target > nums[n-1] || target < nums[0]) {
            return -1;
        }

        //start bs
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                //continue search left
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    private int right_bound(int[] nums, int target) {
        int n = nums.length;
        //check if out of boundary
        if (target > nums[n-1] || target < nums[0]) {
            return -1;
        }

        //start bs
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                //continue search right
                left = mid + 1;
            }
        }
        return nums[right] == target ? right : -1;
    }
}
