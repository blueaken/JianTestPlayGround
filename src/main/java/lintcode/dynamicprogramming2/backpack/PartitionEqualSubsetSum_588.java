package lintcode.dynamicprogramming2.backpack;

import java.util.Arrays;

public class PartitionEqualSubsetSum_588 {
    /**
     * @param nums: a non-empty array only positive integers
     * @return: true if can partition or false
     */
    //Idea: 等价背包问题，能否达到总价值的一半，
    //      Ref - https://www.youtube.com/watch?v=s6FhG--P7z0&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
    //      Note - 数组不需要排序
    public boolean canPartition(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return true;
        }

        //cal target
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = 0;
        if (sum % 2 == 1) {
            return false;
        } else {
            target = sum / 2;
        }

        //init
        int len = nums.length;
        boolean[][] res = new boolean[len+1][target+1];
        for (int i = 0; i <= len; i++) {
            res[i][0] = true;
        }

        //dp
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i-1] > j) {
                    res[i][j] = res[i-1][j];
                } else {
                    res[i][j] = res[i-1][j] || res[i-1][j-nums[i-1]];
                }
            }
        }

        return res[len][target];
    }
}
