package ninechapter.chapter4_dynamic_prgramming_1.longestincreasingsequence;

/**
 * Author: blueaken
 * Date: 3/5/16 3:48 PM
 */
public class Solution_After_Class {
    public static int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //init
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
        }

        //dp
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    f[i] = Math.max(f[j] + 1, f[i]);
                }
            }
        }

        //find max f[i]
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(f[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] test = {4,2,4,5,3,7};
//        int[] test = {10,1,11,2,12,3,11};
        int[] test = {10,9,2,5,3,7,101,18,1,1};

        System.out.println(longestIncreasingSubsequence(test));
    }
}
