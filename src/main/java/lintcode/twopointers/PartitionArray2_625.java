package lintcode.twopointers;

import java.util.Arrays;

public class PartitionArray2_625 {
    /**
     * @param nums: an integer array
     * @param low: An integer
     * @param high: An integer
     * @return: nothing
     */
    public void partition2(int[] nums, int low, int high) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;

        // 首先把区间分为 < low 和 >= low 的两个部分
        while (left < right) {
            while (left < right && nums[left] < low) {
                left++;
            }
            while (left < right && nums[right] >= low) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            }
        }

        // 然后从 >= low 的部分里分出 <= high 和 > high 的两个部分
        right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] <= high) {
                left++;
            }
            while (left < right && nums[right] > high) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            }
        }

        return;
    }


    public static void main(String[] args) {
        int[] input = {4,3,4,1,2,3,1,2};
        int low = 2;
        int high = 2;

        PartitionArray2_625 solution = new PartitionArray2_625();
        solution.partition2(input, low, high);
        System.out.println(Arrays.toString(input));
    }
}
