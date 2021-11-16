package lintcode.colleciton.selected.phase3_array;

import java.util.Arrays;

public class RotateArray_BigO_1_1334 {
    /**
     * @param nums: an array
     * @param k: an integer
     * @return: rotate the array to the right by k steps
     */
    public static int[] rotate(int[] nums, int k) {
        // Write your code here
        int len = nums.length;
        //k超过数组长度取mod，循环一圈时省略那一圈
        if (k >= len) {
            k = k % len;
        }
        int[] head = Arrays.copyOfRange(nums, len - k, len);
        int[] tail = Arrays.copyOfRange(nums, 0, len - k);

        System.arraycopy(head, 0, nums, 0, head.length);
        System.arraycopy(tail, 0, nums, head.length, tail.length);

        return nums;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7};
        int k = 3;
        System.out.print(Arrays.toString(rotate(input, 3)));
    }
}
