package lintcode.binarysearch.labuladong.variant;

public class SearchRotatedSortedArray2_LE_81 {
    /**
     ref 东哥 post
     - similar to 33, the diff is there are dulicates in 81 and we need to remove the duplicates before binary search
     */
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //remove duplicates before BS
            while (left < right && nums[left] == nums[left+1]) {
                left++;
            }
            while (left < right && nums[right] == nums[right-1]) {
                right--;
            }

            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] >= nums[left]) {
                //left half are sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left= mid + 1;
                }
            } else {
                //right half are sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
