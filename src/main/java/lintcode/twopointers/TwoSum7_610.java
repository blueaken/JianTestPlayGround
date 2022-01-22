package lintcode.twopointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSum7_610 {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [num1, num2] (num1 < num2)
     */
    //Idea: Similar to basic Two Sum, 因为是差，降序也算一遍
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        if (nums.length == 0 || nums.length < 2) {
            return new int[] {-1, -1};
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.keySet().contains(target + nums[i])) {
                return new int[] {target + nums[i], nums[i]};
            }
            map.put(nums[i], i);
        }

        //因为是差，降序再扫一遍
        map = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (map.keySet().contains(target + nums[i])) {
                return new int[] {nums[i], target + nums[i]};
            }
            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
