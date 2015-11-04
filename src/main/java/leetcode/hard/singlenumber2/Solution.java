package leetcode.hard.singlenumber2;

/**
 * Author: blueaken
 * Date: 10/9/15 9:59 AM
 */
public class Solution {
    public static int singleNumber(int[] nums) {
        if (nums == null) return -999;

        int result = 0;
        int count[] = new int[32];
        int num = nums.length;
        for (int i=0; i<32; i++){
            for (int j=0; j<num; j++){
                if (((nums[j]>>i)&1)>0) {
                    count[i]++;
                }
            }
            result |= (count[i]%3) << i;
        }

        return result;
    }

    public static void main(String[]args){
        int[] input = {2,2,2,3,3,3,4,4,4,-1,-1,-1,8};
//        int[] input = null;

        System.out.println(singleNumber(input));
    }
}
