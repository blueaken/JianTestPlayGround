package leetcode.hard.singlenumber3;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 10/10/15 8:58 AM
 */
public class Solution {
    public static int[] singleNumber(int[] nums) {
        if (nums==null) return null;
        int[] result = new int[2];

        //1st pass - get the xor result
        int xor =  0;
        for (int a : nums){
            xor ^= a;
        }

        //2nd pass - find the right most set bit of the xor
        int mask = 1;
        while ((xor & mask) == 0) {
            mask = mask << 1;
        }

        //3rd pass - diff the single numbers
        for (int a : nums){
            if ((a & mask) == 0){
                result[0] ^= a;
            } else{
                result[1] ^= a;
            }
        }

        return result;
    }

    public static void main(String[]args){
        int[] input = {2,2,3,3,4,4,-1,8};
//        int[] input = null;

        System.out.println(Arrays.toString(singleNumber(input)));
    }
}
