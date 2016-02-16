package leetcode.hard.singlenumber2.second;

/**
 * Author: blueaken
 * Date: 2/15/16 11:14 AM
 */
public class Solution {

    public static int singleNumber(int[] nums) {
        if (nums == null) return 0;

        int result = 0;
        int[] count = new int[32];

//        for (int i : nums){
//            for (int j=0; j<32; j++) {
//                count[j] += i & 1;
//                i = i >> 1;
//            }
//        }
//
//        for (int i=0; i<32; i++){
//            result |= (count[i]%3) << i;
//        }

        for (int i=0; i<32; i++){
            for (int n : nums){
                count[i] += n>>i & 1;
            }
            result |= (count[i]%3) << i;
        }

        return result;
    }



    public static void main(String[]args){
        //tc 1
        int[] input = {2,2,2,3,3,3,4,4,4,-1,-1,-1,8};

        //tc 2
//        int[] input = null;

        System.out.println(singleNumber(input));
    }

}
