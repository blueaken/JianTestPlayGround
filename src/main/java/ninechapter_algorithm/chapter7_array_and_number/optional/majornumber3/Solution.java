package ninechapter_algorithm.chapter7_array_and_number.optional.majornumber3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 5/27/16 16:10
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public static int majorityNumber(List<Integer> nums, int k) {
        // write your code
        if (nums == null || nums.size() == 0 || k > nums.size()) {
            return -1;
        }

        //similar to major number ii, init k - 1 values
        Map<Integer, Integer> countMap = new HashMap<>();
        int i = 0;
        while (i < k - 1) {
            int cur = nums.get(i);
            if (countMap.containsKey(cur)) {
                countMap.put(cur, countMap.get(cur) + 1);
            } else {
                countMap.put(cur, 1);
            }
            i++;
        }

        //loop the rest of list and maintain the k - 1 candidates list
        while (i < nums.size()) {
            int cur = nums.get(i);
            if (countMap.containsKey(cur)) {
                countMap.put(cur, countMap.get(cur) + 1);
            } else {
                if (countMap.values().contains(0)) {
                    for (int key : countMap.keySet()) {
                        if (countMap.get(key) == 0) {
                            countMap.remove(key);
                            countMap.put(cur, 1);
                            break;
                        }
                    }
                } else {
                    for (int key : countMap.keySet()) {
                        countMap.put(key, countMap.get(key) - 1);
                    }
                }
            }
            i++;
        }

        //loop the original list again and select the max size of the k - 1 candidates
        Map<Integer, Integer> newMap = new HashMap<Integer, Integer>();
        int maxCount = 0;
        int maxNum = 0;
        for (int j = 0; j < nums.size(); j++) {
            int cur = nums.get(j);
            if (countMap.containsKey(cur)) {
                newMap.put(cur, newMap.get(cur) == null ? 1 : newMap.get(cur) + 1);
                if (newMap.get(cur) > maxCount) {
                    maxCount = newMap.get(cur);
                    maxNum = cur;
                }
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        List<Integer> test = Arrays.asList(1,2,3,4,4,5);
        int k =  4;
        System.out.println(majorityNumber(test, k));
    }
}
