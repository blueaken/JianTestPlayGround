package lintcode.binarysearch.byValue;

public class SplitArrayLargestSum_LE_410_P1 {
    /**
     12.09.2022
     exactly the same as 1011
     solve by 东哥 BS template
     ==============
     3.19.2023
     P1
     */
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 1;
        for (int n : nums) {
            left = Math.max(left, n);
            right += n;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            // return the number of groups to divide the nums array within the largest sum of any subarray is mid
            int x = f(nums, mid);
            if (x == k) {
                // find the left boundary
                right = mid;
            } else if (x < k) {
                // need a smaller largest sum to make f() return bigger numbers of group
                right = mid;
            } else {
                // need a bigger largest sum to make f() return smaller number of group
                left = mid + 1;
            }
        }
        return left;
    }

    private int f(int[] nums, int x) {
        int groups = 0;
        for (int i = 0; i < nums.length;) {
            int largestSum = x;
            while (i < nums.length) {
                if (largestSum < nums[i]) {
                    break;
                }
                largestSum -= nums[i];
                i++;
            }
            groups++;
        }
        return groups;
    }
}
