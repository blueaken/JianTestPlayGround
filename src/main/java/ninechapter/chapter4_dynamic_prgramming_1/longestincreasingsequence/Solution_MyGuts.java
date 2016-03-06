package ninechapter.chapter4_dynamic_prgramming_1.longestincreasingsequence;

import java.util.List;
import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 3/3/16 12:14 PM
 */
public class Solution_MyGuts {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public static int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= temp.get(temp.size()-1)) {
                    temp.add(nums[j]);
                }
            }
            if (temp.size() > lis.size()) {
                lis = temp;
            }
        }

        return lis.size();
    }

    public static void main(String[] args) {
//        int[] test = {4,2,4,5,3,7};
        int[] test = {10,1,11,2,12,3,11};

        System.out.println(longestIncreasingSubsequence(test));
    }
}
