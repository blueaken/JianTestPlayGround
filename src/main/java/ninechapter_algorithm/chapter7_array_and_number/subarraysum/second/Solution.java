package ninechapter_algorithm.chapter7_array_and_number.subarraysum.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 5/19/16 09:29
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.keySet().contains(sum)) {
                result.add(map.get(sum) + 1);
                result.add(i);
                return result;
            }
            map.put(sum, i);
        }
        return result;
    }

}
