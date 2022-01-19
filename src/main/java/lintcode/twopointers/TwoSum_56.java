package lintcode.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_56 {
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
                result[1] = i;
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {2,7,11,15};
        int k = 9;

        TwoSum_56 solution = new TwoSum_56();
        System.out.println(Arrays.toString(solution.twoSum(input, k)));
    }
}
