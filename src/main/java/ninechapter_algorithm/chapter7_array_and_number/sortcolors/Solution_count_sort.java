package ninechapter_algorithm.chapter7_array_and_number.sortcolors;

/**
 * Author: blueaken
 * Date: 4/27/16 4:02 PM
 */
public class Solution_count_sort {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                default:
                    break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (count0 != 0) {
                nums[i] = 0;
                count0--;
            } else if (count1 != 0) {
                nums[i] = 1;
                count1--;
            } else {
                nums[i] = 2;
            }

        }

    }
}
