package lintcode.prefixsum;

import java.util.ArrayList;
import java.util.List;

public class MaxTwoSubArrays_42 {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    // ref - https://www.lintcode.com/problem/42/solution/17495
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        int[] left = new int[nums.size()];
        int curMax = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            if (curMax <= 0) {
                curMax = nums.get(i);
            } else {
                curMax += nums.get(i);
            }
            maxSum = Math.max(maxSum, curMax);
            left[i] = maxSum;
        }

        int[] right = new int[nums.size()];
        curMax = 0; maxSum = Integer.MIN_VALUE;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (curMax <= 0) {
                curMax = nums.get(i);
            } else {
                curMax += nums.get(i);
            }
            maxSum = Math.max(maxSum, curMax);
            right[i] = maxSum;
        }

        maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            maxSum = Math.max(maxSum, left[i] + right[i+1]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
//        input.add(5);
//        input.add(4);
//        //9

//        input.add(1);
//        input.add(3);
//        input.add(-1);
//        input.add(2);
//        input.add(-1);
//        input.add(2);
//        //7

        input.add(0);
        input.add(-2);
        //1

        MaxTwoSubArrays_42 solution = new MaxTwoSubArrays_42();
        System.out.println(solution.maxTwoSubArrays(input));
    }
}
