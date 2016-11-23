package ninechapter_algorithm.chapter7_array_and_number.partitionarray.second;

/**
 * Author: blueaken
 * Date: 5/23/16 11:22
 */
public class Solution {
    /**
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        //write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] < k) {
                i++;
            }
            while (i < j && nums[j] >= k) {
                j--;
            }
            swap(nums, i, j);
        }

        i = 0;
        while (i < nums.length) {
            if (nums[i] >= k) {
                break;
            }
            i++;
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
