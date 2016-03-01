package ninechapter.chapter2_binarysearch.otherrelatedretatedarray.recoverrotatedsortedarray;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 3/1/16 9:28 AM
 */
public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public static void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() < 2) {
            return;
        }

        int pivotIndex = -1;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i+1)) {
                pivotIndex = i;
            }
        }

        if (pivotIndex == -1) {
            return;
        }

        reverse(nums, 0, pivotIndex);
        reverse(nums, pivotIndex + 1, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);
    }

    private static void reverse(ArrayList<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            Integer temp;
            temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
//        nums.add(4);
//        nums.add(5);
//        nums.add(1);
//        nums.add(2);
//        nums.add(3);

        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);

        recoverRotatedSortedArray(nums);
        System.out.println(nums);
    }
}
