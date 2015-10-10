package leetcode.medium.singlenumber;

/**
 * Author: blueaken
 * Date: 10/8/15 2:41 PM
 */
public class Solution {
    public static int singleNumber(int[] nums) {
        if (nums==null) return -999;
        int result = 0;
        for (int x : nums){
            result = result ^ x;
        }

        return result;
    }

    public static void main(String[]args){
        int[] input = {2,2,3,3,4,4,-1,-1,8};
//        int[] input = null;

        System.out.println(singleNumber(input));
    }
}
