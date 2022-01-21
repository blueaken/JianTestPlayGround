package lintcode.twopointers;

import java.util.Arrays;

public class TwoSum2_443 {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    //Idea：排序后，发现的第一对left和right大于target时，所有left和right之间的数都满足条件
    public int twoSum2(int[] nums, int target) {
        // write your code here
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        int count = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                count += right - left;
                right--;
            } else {
                left++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] input = {-1,-2,-100,-111,-11};
        int target = -111;

//        int[] input = {2, 7, 11, 15, 19};
//        int target = 23;

        TwoSum2_443 solution = new TwoSum2_443();
        System.out.println(solution.twoSum2(input, target));
        System.out.println(Arrays.toString(input));
    }

}
