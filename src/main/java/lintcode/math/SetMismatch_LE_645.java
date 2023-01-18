package lintcode.math;

public class SetMismatch_LE_645 {
    /**
     1.18.2023
     ref东哥post, 使用映射思路
     */
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                dup = Math.abs(nums[i]); // 体会一下，为啥不是nums[index], 有点绕
            } else {
                nums[index] *= -1;
            }
        }

        int missing = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }
        return new int[] {dup, missing};
    }
}
