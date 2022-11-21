package lintcode.binarysearch.byValue;

import java.util.Arrays;

public class FindKthSmallestPairDistance_LE_719_P1 {
    /*
        - P1
        - read prev notes again
        - X X X X X X X X
              L     R
          To any given pos R, if nums(R) - nums(L) <= val, then there are L - R such position pairs, ending at pos R
        - Type: Binary Search By Value, kinda of tricky
    */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0, left = 0;
            for (int right = 0; right < nums.length; right++) {
                //find the biggest range that distance between right and left is within mid
                while (nums[right] - nums[left] > mid) {
                    left++;
                }
                count += right - left;
            }

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
