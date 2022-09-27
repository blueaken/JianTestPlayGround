package lintcode.binarySearch.byValue;

import java.util.Arrays;

public class FindKthSmallestPairDistance_LE_719 {
    /*
        - 结合Huifeng Guan video + Solution link
        - https://www.youtube.com/watch?v=rKVivKCchFc
        - Time is O(NLogN)
    */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int start = 0;
        int end = nums[nums.length - 1] - nums[0];
        while (start < end) {
            int mid = start + (end - start) / 2;
            //count with 2 pointers
            int count = 0, left = 0;
            for (int right = 0; right < nums.length; right++) {
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

/*
    X X X L X X X R X X X
          3       7
    - for num at position R, when nums[R] - nums{L] <= mid, end at position R, there are 'R - L' such pairs
*/
}
