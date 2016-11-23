package ninechapter_algorithm.chapter2_binarysearch.otherrelated.recoverrotatedsortedarray.second;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 4/14/16 10:32 AM
 */
public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public static void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return;
        }

        //find min
        int start = 0;
        int end = nums.size() - 1;
        while (start < end && nums.get(start) >= nums.get(end)) {
            int mid = (start + end) / 2;
            if (nums.get(mid) > nums.get(end)) {
                start = mid + 1;
            } else if (nums.get(mid) < nums.get(end)) {
                end = mid;
            } else { //mid value equals end value
                start++;
            }

        }
        //min in start position

        reverse(nums, start, nums.size() - 1);
        reverse(nums, 0, start - 1);
        reverse(nums, 0, nums.size() - 1);
    }

    private static void reverse (ArrayList<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(5);
        nums.add(1);
        nums.add(2);
        nums.add(3);

//        nums.add(1);
//        nums.add(2);
//        nums.add(3);
//        nums.add(4);
//        nums.add(5);
//        nums.add(6);

        recoverRotatedSortedArray(nums);
        System.out.println(nums);
    }
}
