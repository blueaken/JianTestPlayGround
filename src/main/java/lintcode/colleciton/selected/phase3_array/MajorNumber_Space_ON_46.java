package lintcode.colleciton.selected.phase3_array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorNumber_Space_ON_46 {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    //时间复杂度O(n), 空间复杂度O(n)
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        Map<Integer, Integer> count = new HashMap<>();
        for (Integer i : nums) {
            if (count.get(i) == null) {
                count.put(i, 1);
            } else {
                count.put(i, count.get(i) + 1);
            }
        }

        int maxCount = Integer.MIN_VALUE;
        int maxNum = -1;
        for (Integer i : count.keySet()) {
            if (count.get(i) > maxCount) {
                maxCount = count.get(i);
                maxNum = i;
            }
        }
        return maxNum;
    }
}
