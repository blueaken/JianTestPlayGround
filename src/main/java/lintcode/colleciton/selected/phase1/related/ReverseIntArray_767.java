package lintcode.colleciton.selected.phase1.related;

import java.util.Arrays;

public class ReverseIntArray_767 {
    /**
     * @param nums: a integer array
     * @return: nothing
     */
    public static void reverseArray(int[] nums) {
        // write your code here
        int i = 0;
        int j = nums.length - 1;
        int temp = 0;
        while (i < j) {
            temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
        return;
    }

    public static void main(String[] args){
        int[] input = {3,5,1};
        reverseArray(input);
        System.out.println(Arrays.toString(input));
    }
}
