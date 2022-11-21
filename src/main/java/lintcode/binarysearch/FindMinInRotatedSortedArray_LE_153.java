package lintcode.binarysearch;

public class FindMinInRotatedSortedArray_LE_153 {
    /*
        - keep comparing with nums[0] and adjust search range
        - 本题必有解，因此当收敛到low = high时，返回
        - binary search
    */
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        //if not rotated return nums[low] directly
        if (nums[high] >= nums[low]) {
            return nums[low];
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= nums[0]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
