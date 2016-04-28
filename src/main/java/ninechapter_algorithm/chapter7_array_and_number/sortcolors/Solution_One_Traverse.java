package ninechapter_algorithm.chapter7_array_and_number.sortcolors;

/**
 * Author: blueaken
 * Date: 4/27/16 4:02 PM
 */
public class Solution_One_Traverse {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }

        int redPos = 0;
        int bluePos = nums.length - 1;
        int i = 0;
        while (i <= bluePos) {
            if (nums[i] == 0) {
                swap(nums, i, redPos);
                i++;
                redPos++;
                continue;
            }
            if (nums[i] == 2) {
                swap(nums, i, bluePos);
                //i++;
                bluePos--;
                continue;
            }
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
