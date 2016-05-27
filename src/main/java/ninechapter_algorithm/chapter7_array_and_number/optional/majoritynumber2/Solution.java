package ninechapter_algorithm.chapter7_array_and_number.optional.majoritynumber2;

import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 5/27/16 10:19
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public static int majorityNumber(List<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return -1;
        }

        int candidate1 = nums.get(0);
        int candidate2 = Integer.MIN_VALUE;
        int count1 = 1;
        int count2 = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) == candidate1) {
                count1++;
            } else if (nums.get(i) == candidate2) {
                count2++;
            } else if (candidate2 == Integer.MIN_VALUE) {
                candidate2 = nums.get(i);
                count2++;
            } else {
                count1--;
                count2--;
                if (count1 == 0) {
                    candidate1 = nums.get(i);
                    count1 = 1;
                }
                if (count2 == 0) {
                    candidate2 = nums.get(i);
                    count2 = 1;
                }
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == candidate1) {
                count1++;
            }
            if (nums.get(i) == candidate2) {
                count2++;
            }
        }
        return count1 > count2 ? candidate1 : candidate2;
    }

    public static void main(String[] args) {
        List<Integer> test = Arrays.asList(99,2,99,2,99,3,3);
        System.out.println(majorityNumber(test));
    }
}
