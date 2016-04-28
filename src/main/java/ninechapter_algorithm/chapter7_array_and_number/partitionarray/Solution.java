package ninechapter_algorithm.chapter7_array_and_number.partitionarray;

/**
 * Author: blueaken
 * Date: 4/23/16 4:06 PM
 */
public class Solution {
    /**
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public static int partitionArray(int[] nums, int k) {
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

            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++; j--;
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

    public static void main(String[] args) {
//        int[] nums = {3,2,2,1};
//        int k = 2;

        int[] nums = {2,0,2,2,1,2,2,1,2,0,0,0,1};
        int k = 1;

        System.out.println(partitionArray(nums, k));
    }
}
