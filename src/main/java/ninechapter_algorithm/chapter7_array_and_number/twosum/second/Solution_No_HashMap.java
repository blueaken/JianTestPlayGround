package ninechapter_algorithm.chapter7_array_and_number.twosum.second;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 5/24/16 10:05
 */
public class Solution_No_HashMap {
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] result = new int[2];
        if (numbers == null || numbers.length == 0) {
            return result;
        }

        Arrays.sort(numbers);
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int twosum = numbers[start] + numbers[end];
            if (twosum == target) {
                //note the result is value not index, for practice purpose only
                result[0] = numbers[start];
                result[1] = numbers[end];
                return result;
            } else if (twosum < target) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }
}
