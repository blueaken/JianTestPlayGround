package lintcode.twopointers;

public class MoveZeroes_LE_283 {
    /**
     ref 东哥 post
     - 相当于 27. 的一个变化，删除value为0的元素后，后面位置补上0即可
     */
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }
}
