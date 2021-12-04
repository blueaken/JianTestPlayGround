package lintcode.colleciton.selected.phase3_array;

import java.util.List;

public class MajorNumber_Space_O1_46 {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    //挑战：时间复杂度O(n), 空间复杂度O(1)
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        int curMajor = 0;
        int count = 0;
        for (Integer i : nums) {
            if (count == 0) {
                curMajor = i;
            }

            if (i == curMajor) {
                count++;
            } else {
                count--;
            }
        }

        return curMajor;
    }
}
