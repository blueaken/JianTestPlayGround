package lintcode.colleciton.selected.phase3_and_phase4_array;

public class MoveZeros_539 {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        int left = 0, right = 0; //两根指针先指向数组头部
        while (right < nums.length) {
            //遍历right, 先排好所有非0元素的位置
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
            right ++;
        }

        //若left还未指向尾部，将剩余数组赋值为0，排好所有0的位置
        while (left < nums.length) {
            nums[left++] = 0;
        }

        return;
    }
}
