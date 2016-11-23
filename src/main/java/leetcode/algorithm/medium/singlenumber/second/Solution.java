package leetcode.algorithm.medium.singlenumber.second;

/**
 * Author: blueaken
 * Date: 2/15/16 11:01 AM
 */
public class Solution {

    /*
     Note:
     Your algorithm should have a linear runtime complexity.
     Could you implement it without using extra memory?
     */

    public static int singleNumber(int[] nums) {
        if (nums == null) return 0;

        int result = 0;
        for (int i : nums){
            result ^= i;
        }

        return result;
    }

    public static void main(String[]args){
        //tc 1
        int[] input = {2,2,3,3,4,4,-1,-1,8};

        //tc 2
//        int[] input = null;

        System.out.println(singleNumber(input));
    }
}
