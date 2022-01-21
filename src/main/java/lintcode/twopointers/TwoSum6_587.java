package lintcode.twopointers;

import java.util.Arrays;

public class TwoSum6_587 {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                count++;
                while (left < right && nums[left + 1] == nums[left]) {
                    left++;
                }
                left++;
                while (left < right && nums[right - 1] == nums[right]) {
                    right--;
                }
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] input = {1,1,2,45,46,46};
        int target = 47;

        TwoSum6_587 solution = new TwoSum6_587();
        System.out.println(solution.twoSum6(input, target));
        System.out.println(Arrays.toString(input));
    }
}
