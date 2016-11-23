package ninechapter_algorithm.chapter7_array_and_number.sortcolors.second;

/**
 * Author: blueaken
 * Date: 5/23/16 09:01
 */
public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }

        int len = nums.length;
        int redPos = 0;
        int bluePos = len - 1;
        int cur = 0;
        while (cur <= bluePos) {
            if (nums[cur] == 0) {
                swap(nums, cur, redPos);
                cur++;
                redPos++;
                continue;
            }
            if (nums[cur] == 2) {
                swap(nums, cur, bluePos);
                //cur++;
                bluePos--;
                continue;
            }
            cur++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //test cur must move when 0
//        int[] test = {2,0,0,1,2,0,2};

        int[] test = {2,0,2,2,1,2,2,1,2,0,0,0,1};

        solution.sortColors(test);
    }
}
