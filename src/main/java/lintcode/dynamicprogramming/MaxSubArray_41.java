package lintcode.dynamicprogramming;

public class MaxSubArray_41 {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    //Idea: 参考CG大作，试用局部和全局最优解方法来解
    //      Ref - https://blog.csdn.net/linhuanmars/article/details/21314059
    public int maxSubArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int local = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //局部最优一定会包括当前element
            local = Math.max(nums[i], nums[i] + local);
            //全局最优未必包括当前element，可以选前面节点的全局最优
            global = Math.max(local, global);
        }
        return global;
    }

    public static void main(String[] args) {
        int[] nums = {-2,2,-3,4,-1,2,1,-5,3};

        MaxSubArray_41 solution = new MaxSubArray_41();
        System.out.println(solution.maxSubArray(nums));
    }
}
