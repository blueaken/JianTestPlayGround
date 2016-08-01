package ninechapter_algorithm.chapter7_array_and_number.twosum.third;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 8/1/16 09:05
 */
public class Solution_HashMap {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] result = new int[2];
        if (numbers == null || numbers.length == 0) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.keySet().contains(target - numbers[i])) {
                result[0] = map.get(target - numbers[i]);
                result[1] = i + 1;
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }
}
