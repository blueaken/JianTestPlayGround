package ninechapter_algorithm.chapter2_binarysearch.otherrelated.recoverrotatedsortedarray.third;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 6/24/16 10:03
 */
public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return;
        }

        int pivotIndex = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                pivotIndex = i;
            }
        }
        if (pivotIndex != 0) {
            reverseArray(nums, 0, pivotIndex);
            reverseArray(nums, pivotIndex + 1, nums.size() - 1);
            reverseArray(nums, 0, nums.size() - 1);
        }
        return;
    }

    private void reverseArray(ArrayList<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start++, nums.get(end));
            nums.set(end--, temp);
        }
    }
}
