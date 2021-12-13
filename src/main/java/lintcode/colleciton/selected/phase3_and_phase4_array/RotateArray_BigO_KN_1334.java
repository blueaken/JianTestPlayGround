package lintcode.colleciton.selected.phase3_and_phase4_array;

public class RotateArray_BigO_KN_1334 {
    /**
     * @param nums: an array
     * @param k: an integer
     * @return: rotate the array to the right by k steps
     */
    public int[] rotate(int[] nums, int k) {
        // Write your code here
        for (int i = 0; i < k; i++) {
            rightRotate(nums);
        }
        return nums;
    }

    private void rightRotate (int[] nums) {
        int len = nums.length;
        int right = nums[len-1];
        for (int i = len-1; i > 0; i--) {
            nums[i] = nums[i-1];
        }
        nums[0] = right;
    }
}
