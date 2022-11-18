package lintcode.twopointers;

public class RemoveDuplicatesFromSortedArray_LE_26 {
    /**
     ref 东哥 post
     solve with slow/fast pointer
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1; //array index is 0 based
    }
}
