package lintcode.binarySearch;

import java.util.Arrays;

public class SimpleQueries_1791 {
    /**
     * @param nums:
     * @param sub:
     * @return: return a Integer array
     */
    //Idea: sort the array, then BS(with nine chapter template) to find the rightmost index to each element of sub
    public int[] SimpleQueries (int[] nums, int[] sub) {
        // write your code here
        int[] res = new int[sub.length];
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < sub.length; i++) {
            if (sub[i] < nums[0]) {
                res[i] = 0;
            } else if (sub[i] > nums[nums.length-1]) {
                res[i] = nums.length;
            } else {
                int start = 0, end = nums.length - 1;
                while (start + 1 < end) {
                    int mid = start + (end - start) / 2;
                    if (nums[mid] <= sub[i]) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                }
                if (nums[end] == sub[i]) {
                    res[i] = end + 1;
                } else {
                    res[i] = start + 1;
                }
            }
        }

        return res;
    }
}
