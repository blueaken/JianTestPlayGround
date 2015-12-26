package leetcode.easy.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 12/9/15 6:21 PM
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i=0; i<nums.length; i++){
            int cur = nums[i];
            if (map.keySet().contains(target-cur)){
                result[0] = map.get(target-cur);
                result[1] = i;
                break;
            }
            if (!map.keySet().contains(cur)){
                map.put(cur, i);
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] numbers = {2, 7, 11, 15};
        int target=9;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}
