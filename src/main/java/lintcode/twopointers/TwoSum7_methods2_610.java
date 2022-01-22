package lintcode.twopointers;

public class TwoSum7_methods2_610 {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [num1, num2] (num1 < num2)
     */
    //Ref - https://www.lintcode.com/problem/610/solution/18062
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        if (nums.length == 0 || nums.length < 2) {
            return new int[] {-1, -1};
        }

        target = Math.abs(target);
        int right = 1;
        for (int left = 0; left < nums.length - 1; left++) {
            right = Math.max(right, left + 1);
            while (right < nums.length && nums[right] - nums[left] < target) {
                right++;
            }
            if (right == nums.length) {
                break;
            }
            if (nums[right] - nums[left] == target) {
                return new int[] {nums[left], nums[right]};
            }
        }

        return new int[] {-1, -1};
    }
}
