package ninechapter_algorithm.chapter7_array_and_number.optional.majoritynumber;

import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 5/27/16 09:28
 */
public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public static int majorityNumber(List<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return -1;
        }

        //find majority number candidate
        int maj = nums.get(0);
        int count = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) == maj) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    maj = nums.get(i);
                    count = 1;
                }
            }
        }

        //verify if there exists a major number, return maj candidate if ture
        count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == maj) {
                count++;
            }
        }
        return count > nums.size() / 2 ? maj : -1;
    }

    public static void main(String[] args) {
        List<Integer> test = Arrays.asList(2,1,2,1,2);
        System.out.println(majorityNumber(test));
    }
}
