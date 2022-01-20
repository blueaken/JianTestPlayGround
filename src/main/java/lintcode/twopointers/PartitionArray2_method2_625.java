package lintcode.twopointers;

import java.util.Arrays;

public class PartitionArray2_method2_625 {
    /**
     * @param nums: an integer array
     * @param low: An integer
     * @param high: An integer
     * @return: nothing
     */
    //Method 2: 类似快速排序的思路去分割即可，遇到不满足即交换
    //Ref - https://www.lintcode.com/problem/625/solution/25273
    public void partition2(int[] nums, int low, int high) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] < low ) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] > high) {
                swap(nums, right, i);
                right--;
            } else {
                i++;
            }
        }
        return;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
//        int[] input = {4,3,4,1,2,3,1,2};
//        int low = 2;
//        int high = 2;

        int[] input = {3,2,1};
        int low = 2;
        int high = 3;

        PartitionArray2_method2_625 solution = new PartitionArray2_method2_625();
        solution.partition2(input, low, high);
        System.out.println(Arrays.toString(input));
    }
}
