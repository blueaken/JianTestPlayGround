package lintcode.binarysearch.byValue;

import java.util.Arrays;

public class FindKthSmallestPairDistance_LE_719_P2 {
    /*
   - 结合Huifeng Guan video + Solution link
   - https://www.youtube.com/watch?v=rKVivKCchFc
   - Time is O(NLogN)
   ==========================
   - P1
   - read prev notes again
   - X X X X X X X X
         L     R
     To any given pos R, if nums(R) - nums(L) <= val, then there are L - R such position pairs, ending at pos R
   - Type: Binary Search By Value, kinda of tricky
   ==========================
   P2 11.21.2022
   - ref prev notes
   - solve by binary search by value
   ==========================
   */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0, end = nums[nums.length-1] - nums[0];
        while (start < end) {
            int mid = start + (end - start) / 2;
            int left =0, count = 0;
            for (int right = 0; right < nums.length; right++) {
                //find the biggest range that distance between right and left is within mid
                while (nums[right] - nums[left] > mid) {
                    left++;
                }
                count += right - left;
            }

            if (count < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
