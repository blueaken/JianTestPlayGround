package leetcode.algorithm.easy.plusone;

import java.util.Arrays;

/**
 * Created by jshe18 on 8/22/15.
 */
public class Solution {
    private static Integer MAX_DIV_10 = Integer.MAX_VALUE/10;

    public static int[] plusOne(int[] digits) {
        if (digits.length==0) return digits;

        int num = 0;
        for (int i=0; i<digits.length; i++){
            if (num > MAX_DIV_10 || num==MAX_DIV_10 && digits[i]>=8) return null;
            num = num*10 + digits[i];
        }


        String temp = Integer.toString(num+1);

        int[] result = new int[temp.length()];
        for (int i=0; i<temp.length(); i++){
            result[i] = temp.charAt(i) - '0';
        }

        return result;
    }

    public static void main(String[] args){
//        int[] digits = {1,2,3};
//        int[] digits = {9,9,9};
        int[] digits = {9,8,7,6,5,4,3,2,1,0};

        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
