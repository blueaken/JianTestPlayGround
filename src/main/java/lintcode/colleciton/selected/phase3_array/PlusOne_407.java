package lintcode.colleciton.selected.phase3_array;

import java.util.Arrays;

public class PlusOne_407 {
    /**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public static int[] plusOne(int[] digits) {
        // write your code here
        int end = digits.length - 1;
        while (end >= 0 && digits[end]++ == 9) {
            digits[end] = 0;
            end--;
        }
        if (end == -1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] input = {9, 9};
        System.out.println(Arrays.toString(plusOne(input)));
    }
}
